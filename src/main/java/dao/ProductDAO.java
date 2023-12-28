package dao;

import db.JDBIConnector;
import entity.Categories;
import entity.Images;
import entity.Products;
import jdbc.JDBCConnection;
import service.CategoryService;
import service.ImageService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDAO {
    CategoryService categoryService = new CategoryService();
    public List<Products> getProductByPage(int currentPage, int productsPerPage) {
        List<Products> list = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name, products.images, categories.name as c_name,categories.id as c_id, products.status, products.description, products.size, products.costPrice,products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id  LIMIT ?,?";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentPage * productsPerPage - productsPerPage);
            ps.setInt(2, productsPerPage);
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

    public List<Products> getAll() {

        List<Products> productList = new ArrayList<Products>();
        String sql = "SELECT products.id, products.name,products.images, categories.name as c_name,categories.id as c_id, products.status," +
                " products.description, products.size, products.costPrice,products.price " +
                "FROM products INNER JOIN categories ON products.categoryID = categories.id";
//        Connection conn = JDBIConnector.connect();
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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
    public int getNoOfProducts() {
        return getAll().size();
    }
}
