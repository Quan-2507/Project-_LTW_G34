package dao;

import entity.Users;
import entity.VerifyAccount;
import jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Connection connection = JDBCConnection.getJDBCConnection();
    public boolean checkLogin(String username, String password) {
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
        String sql = "SELECT a.id,a.name, a.userName, a.password,  a.phoneNumber, a.dateOfBirth, a.address, a.email, a.role, a.status "
        +"FROM users a WHERE a.id = ? ";
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
    public static boolean checkExistUserName(String userName) {
        boolean re = false;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select userName from users where userName =?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, userName);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                re = true;
            }
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    public static boolean checkExistEmail(String email) {
        boolean re = false;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select email from users where email =?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, email);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                re = true;
            }
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static Users selectById(int idU) {
        Users re = null;
        try{
            // Tạo kết nối đến database
            Connection connection = JDBCConnection.getJDBCConnection();
            // Tạo đối tượng statement
            String sql = "select a.id,a.name, a.userName, a.email, a.phoneNumber, a.password, a.role, a.creatAt, a.lastUpdate, a.address, a.status " +
                    "from users as a " +
                    "where a.id =? ";
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, idU);
            // Thực thi câu lệnh sql
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phoneNumber");
                String password = resultSet.getString("password");
                int role = resultSet.getInt("role");
                String createAt = resultSet.getString("createAt");
                String lastUpdate = resultSet.getString("lastUpdate");
                String address = resultSet.getString("address");
                int status = resultSet.getInt("status");
                re = new Users(id, name,userName,email, phoneNumber, password, role, createAt, lastUpdate, address, status);
            }
            JDBCConnection.close(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    public static int registerAccount(Users users) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into users(name, userName, email, phoneNumber, password) values(?,?,?,?,?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, users.getName());
            pr.setString(2, users.getUserName());
            pr.setString(3, users.getEmail());
            pr.setInt(4, users.getPhoneNumber());
            pr.setString(5, users.getPassword());
            re = pr.executeUpdate();
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    public static int insertVerify(VerifyAccount v) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into verify_account(idAccount, verifyCode,timeCode, stateVerify) values(?,?,?,?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, v.getIdAccount());
            pr.setInt(2, v.getVerifyCode());
            pr.setObject(3, v.getTimeCode());
            pr.setBoolean(4, v.isStateVerify());
            re = pr.executeUpdate();
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }

    public static int updateStateVerify(VerifyAccount v) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "update verify_account set stateVerify =? where idAccount =?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setBoolean(1, v.isStateVerify());
            pr.setInt(2, v.getIdAccount());
            pr.executeUpdate();
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("update thanh cong");
        return re;
    }

    public static Users selectAccountByUserName(String username) {
        Users users = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from users  where userName =? ";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, username);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phoneNumber");
                String password = resultSet.getString("password");
                String createAt = resultSet.getString("createAt");
                String lastUpdate = resultSet.getString("lastUpdate");
                String address = resultSet.getString("address");
                users = new Users(id, name,userName,email, phoneNumber, password, createAt, lastUpdate, address);
            }
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static Users selectAccountByEmail(String emailAccount) {
        Users users = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select * from users  where email =? ";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, emailAccount);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phoneNumber");
                String password = resultSet.getString("password");
                String createAt = resultSet.getString("createAt");
                String lastUpdate = resultSet.getString("lastUpdate");
                String address = resultSet.getString("address");
                users = new Users(id, name,userName,email, phoneNumber, password, createAt, lastUpdate, address);
            }
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public static VerifyAccount selectVerifyAccountByIdAccount(int idAccount)  {
        VerifyAccount verifyAccount = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "Select idAccount, verifyCode, timeCode, stateVerify " +
                "from verify_account " +
                "where idAccount = ?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, idAccount);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idAccount");
                int verifyCode = resultSet.getInt("verifyCode");
                LocalDateTime timeCode = resultSet.getObject("timeCode", LocalDateTime.class);
                boolean stateVerify = resultSet.getBoolean("stateVerify");
                verifyAccount = new VerifyAccount(id, verifyCode, timeCode, stateVerify);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCConnection.close(connection);
        return verifyAccount;
    }
    public static int updateVerify(int newCode,LocalDateTime timeNew, int idAccount) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql ="update verify_account set verifyCode =?, timeCode =? where idAccount =?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, newCode);
            pr.setObject(2, timeNew);
            pr.setInt(3, idAccount);
            re = pr.executeUpdate();
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    // Thay đổi thông tin khách hàng
    public static int updateInfor(Users users) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE users " +
                "SET name=?, userName=?, email=?, phoneNumber=?, password=?,  creatAt=?, lastUpdate=?, address=? " +
                "WHERE id=?";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, users.getName());
            pr.setString(2, users.getUserName());
            pr.setString(3, users.getEmail());
            pr.setInt(4, users.getPhoneNumber());
            pr.setString(5, users.getPassword());
            pr.setString(6, users.getCreateAt());
            pr.setString(7, users.getLastUpdate());
            pr.setString(8, users.getAddress());
            pr.setInt(9, users.getId());
            re = pr.executeUpdate();
            JDBCConnection.close(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            JDBCConnection.close(connection);
        }
        return re;
    }

    public static VerifyAccount getVrfOfAccount(int idAccount) {
        VerifyAccount verifyAccount = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "Select stateVerify from verify_account where idAccount =?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, idAccount);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                verifyAccount = new VerifyAccount(resultSet.getBoolean("stateVerify"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verifyAccount;
    }
    public static ArrayList<Users> listAllAccount() {
        ArrayList<Users> list = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select name, userName, email, phoneNumber, password, role, creatAt, lastUpdate, address, status from users ";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phoneNumber");
                String password = resultSet.getString("password");
                int role = resultSet.getInt("role");
                String createAt = resultSet.getString("createAt");
                String lastUpdate = resultSet.getString("lastUpdate");
                String address = resultSet.getString("address");
                int status = resultSet.getInt("status");
                Users user = new Users(id, name,userName,email, phoneNumber, password, role, createAt, lastUpdate, address, status);
                list.add(user);
            }
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  list;
    }
    public static int updatePassword( String passEnCrypt, int idAccount) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql ="update users set password =? where id =?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, passEnCrypt);
            pr.setInt(2, idAccount);
            re = pr.executeUpdate();
            JDBCConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static synchronized int updateStatus(int id, boolean status) throws SQLException {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement  s = connection.prepareStatement("select id from users where id = ?");
            s.setInt(1, id);
            ResultSet resultSet = s.executeQuery();
            if (resultSet.next()) {
                s = connection.prepareStatement("update users set status =? where id = ?");
                s.setBoolean(1, status);
                s.setInt(2, id);
                re = s.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCConnection.close(connection);
        return re;
    }
    public static synchronized int updateInforAccount(Users users) throws SQLException {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement  s = connection.prepareStatement("select id from users where id =?");
            s.setInt(1, users.getId());
            ResultSet resultSet = s.executeQuery();
            if (resultSet.next()) {
                String sql = "";
                if(!users.getPassword().equals("")) {
                    sql = "UPDATE users SET name=?, userName=?, email=?, phoneNumber=?, password=?,  creatAt=?, lastUpdate=?, address=?, role =? where id =?";
                    s = connection.prepareStatement(sql);
                    s.setString(1, users.getName());
                    s.setString(2, users.getUserName());
                    s.setString(3, users.getEmail());
                    s.setInt(4, users.getPhoneNumber());
                    s.setString(5, users.getPassword());
                    s.setString(6, users.getCreateAt());
                    s.setString(7, users.getLastUpdate());
                    s.setString(8, users.getAddress());
                    s.setInt(9, users.getRole());
                }else {
                    sql = "UPDATE users SET name=?, userName=?, email=?, phoneNumber=?, creatAt=?, lastUpdate=?, address=?, role =?  where id =?";
                    s = connection.prepareStatement(sql);
                    s.setString(1, users.getName());
                    s.setString(2, users.getUserName());
                    s.setString(3, users.getEmail());
                    s.setInt(4, users.getPhoneNumber());
                    s.setString(5, users.getCreateAt());
                    s.setString(6, users.getLastUpdate());
                    s.setString(7, users.getAddress());
                    s.setInt(8, users.getRole());
                }
                re = s.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        JDBCConnection.close(connection);
        return re;
    }

}