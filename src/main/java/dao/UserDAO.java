package dao;

import entity.Categories;
import entity.Users;
import jdbc.JDBCConnection;

import java.sql.*;
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
    public List<Users> getAdmin(int role){
        List<Users> list = new ArrayList<Users>();
        String sql = "Select id, name, dateOfBirth, position " +
                "From users WHERE role =?";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,role);
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
    public List<Users> getUser(int role){
        List<Users> list = new ArrayList<Users>();
        String sql = "Select id,name, email, address " +
                "From users WHERE role =?";
        Connection conn = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,role);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setEmail(rs.getString("email"));
                users.setAddress(rs.getString("address"));
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
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getInt("phoneNumber"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                user.setCreateAt(rs.getDate("createAt"));
                user.setLastUpdate(rs.getDate("lastUpdate"));
                user.setAddress(rs.getString("address"));
                user.setStatus(rs.getInt("status"));
                user.setPosition(rs.getString("position"));
                user.setDateOfBirth(rs.getDate("dateOfBirth"));
                return user;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Users> getAll() {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users ";
        Connection conn = JDBCConnection.getJDBCConnection()    ;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Users user = new Users();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                users.add(user);


            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(Users user) {
        System.out.println("Email: " + user.getEmail());
        System.out.println("Username: " + user.getUserName());
        System.out.println("Password: " + user.getPassword());
        int roleId = 0;
        int status = 0;
        String sql = "INSERT INTO users(name, userName, email, phoneNumber, password, role ,createAt,lastUpdate,address,status, position, dateOfBirth) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getPhoneNumber());
            ps.setString(5, user.getPassword());

            try {
                if (user.getRole() == 1) {
                    roleId = 1;
                } else {
                    roleId = 2;
                }
            } catch (Exception e) {
                roleId = 2;
            }

            ps.setInt(6, roleId);
            ps.setDate(7,(Date) user.getCreateAt());
            ps.setDate(8, (Date) user.getLastUpdate());
            ps.setString(9, user.getAddress());
            ps.setInt(10, 1);
            ps.setString(11, user.getPosition());
            ps.setDate(12,(Date) user.getDateOfBirth());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void edit(Users user) {
        String sql = "UPDATE users SET name=?, userName=?, email=?, phoneNumber=?, password=?, role=? ,lastUpdate=?,address=?,status=?, position=?, dateOfBirth=? WHERE id=?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getPhoneNumber());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole());
            ps.setDate(7, (Date) user.getLastUpdate());
            ps.setString(8, user.getAddress());
            ps.setInt(9, user.getStatus());
            ps.setString(10, user.getPosition());
            ps.setDate(11,(Date) user.getDateOfBirth());
            ps.setInt(12, user.getId());
            ps.executeUpdate();
            System.out.println("role  : " + user.getRole());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}