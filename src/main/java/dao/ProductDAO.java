package dao;

import entity.Categories;
import entity.Products;
import entity.Rates;
import jdbc.JDBCConnection;
import service.CategoryService;
import service.RateService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    CategoryService categoryService = new CategoryService();
    RateService rateService = new RateService();
    public List<Products> getProductByPage(int currentPage, int productsPerPage, int categoryID) {
        List<Products> list = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, products.description, products.size, products.costPrice, products.price, rates.id as r_id, AVG(rates.star) AS star " +
                "FROM products " +
                "INNER JOIN categories ON products.categoryID = categories.id " +
                "LEFT JOIN rates ON rates.productID = products.id " +
                "WHERE products.categoryID = ? " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price, rates.id " +
                "LIMIT ?, ?";
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
                Rates rate = rateService.get(rs.getInt("r_id"));
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
                product.setRates(rate);
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
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, " +
                "products.description, products.size, products.costPrice, products.price, rates.id as r_id, AVG(rates.star) AS star " +
                "FROM products " +
                "INNER JOIN categories ON products.categoryID = categories.id " +
                "LEFT JOIN rates ON rates.productID = products.id " +
                "WHERE products.categoryID = ? " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price, rates.id";
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Rates rate = rateService.get(rs.getInt("r_id"));
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
                product.setRates(rate);
                productList.add(product);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
    public List<Products> getAll() {
        List<Products> productList = new ArrayList<>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, " +
                "products.description, products.size, products.costPrice, products.price " +
                "FROM products " +
                "INNER JOIN categories ON products.categoryID = categories.id " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price ";
        try (Connection conn = JDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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

                // Sử dụng đối tượng rate nếu cần
                // product.setRate(rate);

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public int getNoOfProducts(int currentPage, int productsPerPage, int categoryID) {
        return getAll( currentPage,  productsPerPage, categoryID).size();
    }
    public int getNoOfProducts() {
        return getAll().size();
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
                "FROM products INNER JOIN categories ON products.categoryID = categories.id INNER JOIN rates ON rates.productID = products.id " +
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
    public List<Products> bestSeller(){
        List<Products> productsList = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status," +
                " products.description, products.size, products.costPrice, products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id " +
                "INNER JOIN order_details ON products.id = order_details.productID " +
                "INNER JOIN orders ON orders.id = order_details.orderID INNER JOIN rates ON rates.productID = products.id " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price " +
                "ORDER BY SUM(order_details.quantity) DESC LIMIT 4";
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
    public List<Products> searchByName(String txtSearch) {
        List<Products> list = new ArrayList<>();
        if(txtSearch != null && !txtSearch.trim().isEmpty()){
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name, categories.id as c_id, products.status, " +
                "products.description, products.size, products.costPrice, products.price, rates.id as r_id, AVG(rates.star) AS star " +
                "FROM products " +
                "INNER JOIN categories ON products.categoryID = categories.id " +
                "LEFT JOIN rates ON rates.productID = products.id " +
                "WHERE products.name LIKE ? " +
                "GROUP BY products.id, products.name, products.images, categories.name, categories.id, products.status, products.description, products.size, products.costPrice, products.price ";  // Thêm GROUP BY để tránh lỗi khi sử dụng AVG

        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = categoryService.get(rs.getInt("c_id"));
                Rates rate = rateService.get(rs.getInt("r_id"));
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
                product.setRates(rate);
                list.add(product);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        return list;
    }

    public void insert(Products product) {
        String sql = "INSERT INTO products (name, categoryID, status, description, size, costPrice, price, images, createAt, lastUpdate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBCConnection.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getcategory().getId());
            preparedStatement.setInt(3, product.getStatus());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getSize());
            preparedStatement.setInt(6, product.getCostPrice());
            preparedStatement.setInt(7, product.getPrice());
            preparedStatement.setString(8, product.getImages());
            preparedStatement.setDate(9,(Date) product.getCreateAt());
            preparedStatement.setDate(10,(Date) product.getLastUpdate());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
