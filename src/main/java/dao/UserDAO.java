package dao;

import entity.Users;
import jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}