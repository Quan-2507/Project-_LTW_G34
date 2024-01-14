package dao;

import entity.Rates;
import jdbc.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RateDAO {

    public boolean addRating(int userId, int productId, int star, String comment, Date createAt) {
        try {
            String sql = "INSERT INTO rates (userID, productID, star, comment, createAt) VALUES (?, ?, ?, ?, ?)";
            Connection conn = JDBCConnection.getJDBCConnection();
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, userId);
                statement.setInt(2, productId);
                statement.setInt(3, star);
                statement.setString(4, comment);
                statement.setDate(5, (java.sql.Date) createAt);
                int rowsAffected = statement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
            return false;
        }
    }

    // Phương thức để lấy đánh giá trung bình của một sản phẩm từ cơ sở dữ liệu
    public double getAverageRating(int productId) {
        try {
            String sql = "SELECT AVG(star) AS avgRating FROM rates WHERE productID = ?";
            Connection conn = JDBCConnection.getJDBCConnection();
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, productId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getDouble("avgRating");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
        return 0.0; // Trả về giá trị mặc định nếu có lỗi
    }

    // Các phương thức khác có thể bao gồm việc lấy danh sách đánh giá, cập nhật đánh giá, xóa đánh giá, v.v.

    // Ví dụ: Lấy danh sách đánh giá của một sản phẩm
    public List<Integer> getRatingsForProduct(int productId) {
        List<Integer> ratings = new ArrayList<>();
        try {
            String sql = "SELECT star FROM rates WHERE productID = ?";
            Connection conn = JDBCConnection.getJDBCConnection();
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, productId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        ratings.add(resultSet.getInt("star"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }
        return ratings;

    }

    public Rates get(int id) {
        Rates rate = null;

        try {
            String sql = "SELECT * FROM rates WHERE id = ?";
            Connection conn = JDBCConnection.getJDBCConnection();

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        rate = new Rates();
                        rate.setId(resultSet.getInt("id"));
                        rate.setStar(resultSet.getInt("star"));
                        // Các thông tin khác của đánh giá
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
        }

        return rate;
    }


}
