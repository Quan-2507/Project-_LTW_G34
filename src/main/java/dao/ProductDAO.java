package dao;

import entity.Categories;
import entity.Products;
import jdbc.JDBCConnection;
import service.CategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    CategoryService categoryService = new CategoryService();
    public List<Products> getProductByPage(int currentPage, int productsPerPage, int categoryID) {
        List<Products> list = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name,categories.id as c_id, products.status, products.description, products.size, products.costPrice,products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id " +
                "WHERE products.categoryID = ? LIMIT ?, ?";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ps.setInt(2, currentPage * productsPerPage - productsPerPage);
            ps.setInt(3, productsPerPage);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Products product = new Products();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImage(rs.getString("images"));
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                product.setCategory(category);
                list.add(product);
            }
            System.out.println("Câu truy vấn SQL: " + sql);
            System.out.println("currentPage: " + currentPage);
            System.out.println("productsPerPage: " + productsPerPage);
            System.out.println("Number of Products in ResultSet: " + list.size());

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<Products> getAll(int currentPage, int productsPerPage, int categoryID) {

        List<Products> productList = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name,products.images, categories.name as c_name,categories.id as c_id, products.status," +
                " products.description, products.size, products.costPrice,products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id " +
                "WHERE products.categoryID = ?";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Products product = new Products();
                product.setImage(rs.getString("images"));
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(category);
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }
    public int getNoOfProducts(int currentPage, int productsPerPage, int categoryID) {
        return getAll( currentPage,  productsPerPage, categoryID).size();
    }
    public List<String> getMoreImage(int id) {
        ArrayList<String> listImg = new ArrayList<String>();
        String sql = "SELECT path1, path2 ,path3 ,path4 FROM images where productID=?";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                listImg.add(rs.getString("path1"));
                listImg.add(rs.getString("path2"));
                listImg.add(rs.getString("path3"));
                listImg.add(rs.getString("path4"));
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listImg;
    }

    public Products getID (int id) {
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status," +
                " products.description, products.size, products.costPrice, products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id " +
                "WHERE products.id = ?";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Products product = new Products();
                product.setImage(rs.getString("images"));
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(category);
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                return product;
            }

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    public List<Products> bestSeller(int id){
        List<Products> productsList = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status," +
                " products.description, products.size, products.costPrice, products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id " +
                "INNER JOIN order_details ON products.id = order_details.productID " +
                "INNER JOIN orders ON orders.id = order_details.orderID " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price " +
                "ORDER BY SUM(order_details.quantity) DESC";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Products product = new Products();
                product.setImage(rs.getString("images"));
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(category);
                product.setStatus(rs.getInt("status"));
                product.setDescription(rs.getString("description"));
                product.setSize(rs.getString("size"));
                product.setCostPrice(rs.getInt("costPrice"));
                product.setPrice(rs.getInt("price"));
                productsList.add(product);
            }

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productsList;
    }

}
