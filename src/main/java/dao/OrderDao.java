package dao;

import entity.*;
import jdbc.JDBCConnection;
import service.CategoryService;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public List<Orders> get() {
        List<Orders> ordersList = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (Connection conn = JDBCConnection.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Orders orders = new Orders();

                orders.setId(rs.getInt("id"));
                orders.setTotalPrice(rs.getDouble("totalPrice"));
                orders.setBuyDate(rs.getString("buyDate"));
                orders.setStatus(rs.getString("status"));
                orders.setAddress(rs.getString("address"));
                orders.setShippingFee(rs.getDouble("shippingFee"));
                orders.setPayment(rs.getString("payment"));

                ordersList.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Có thể xử lý ngoại lệ một cách thích hợp ở đây
        }

        return ordersList;
    }


}
