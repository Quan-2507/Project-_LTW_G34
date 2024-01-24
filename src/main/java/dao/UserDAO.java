package dao;

import entity.Categories;
import entity.Users;
import jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public boolean checkLogin(String username, String password) {
        Connection connection = JDBCConnection.getJDBCConnection();

        if (connection != null) {
            try {
                String sql = "SELECT * FROM users WHERE email=? AND password=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, username);
                    statement.setString(2, password);

                    try (ResultSet result = statement.executeQuery()) {
                        return result.next();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCConnection.close(connection);
            }
        }
        return false;
    }
    public List<Users> getAdmin(int status){
        List<Users> list = new ArrayList<Users>();
        String sql = "Select id, name, dateOfBirth, position " +
                "From users WHERE status =?";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setDateOfBirth(rs.getDate("dateOfBirth"));
                users.setPosition(rs.getString("position"));
                list.add(users);
            }
            conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
return list;
    }
    public List<Users> getUser(int status){
        List<Users> list = new ArrayList<Users>();
        String sql = "Select users.id, users.name, user.email, address position " +
                "From users inner join address on users.addressID = address.id WHERE status =?";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setDateOfBirth(rs.getDate("dateOfBirth"));
                users.setPosition(rs.getString("position"));
                list.add(users);
            }
            conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public Users get(int id) {
        String sql = "SELECT * FROM users WHERE id = ? ";
        Connection conn = JDBCConnection.getJDBCConnection()    ;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Users user = new Users();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));

                return user;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}