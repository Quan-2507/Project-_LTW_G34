package dao;



import db.JDBIConnector;
import entity.Categories;
import jdbc.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAO extends JDBIConnector{

    public void insert(Categories category) {
        String sql = "INSERT INTO categories(id,name) VALUES (?,?)";
//        Connection con = connect();
        Connection conn = JDBCConnection.getJDBCConnection()    ;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void edit(Categories category) {
        String sql = "UPDATE categories SET name = ? WHERE id = ?";
        Connection conn = JDBCConnection.getJDBCConnection()    ;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM categories WHERE id = ?";
        Connection conn = JDBCConnection.getJDBCConnection()    ;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public Categories get(int id) {
        String sql = "SELECT * FROM categories WHERE id = ? ";
        Connection conn = JDBCConnection.getJDBCConnection()    ;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = new Categories();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                return category;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Categories> getAll() {
        List<Categories> categories = new ArrayList<Categories>();
        String sql = "SELECT * FROM categories";
        Connection conn = JDBCConnection.getJDBCConnection()    ;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = new Categories();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }


    public List<Categories> search(String keyword) {
        List<Categories> categories = new ArrayList<Categories>();
        String sql = "SELECT * FROM categories WHERE name LIKE ? ";
        Connection conn = JDBCConnection.getJDBCConnection()    ;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = new Categories();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }


    public Categories get(String name) {
        String sql = "SELECT * FROM categories WHERE name = ? ";
        Connection conn = JDBCConnection.getJDBCConnection()    ;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categories category = new Categories();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                return category;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}