package dao;

import entity.*;
import jdbc.JDBCConnection;
import service.OrderService;
import service.ProductService;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    static UserService userService = new UserService();
    static OrderService orderService = new OrderService();
    static ProductService productService = new ProductService();
    public static ArrayList<Orders> listOrders() {
        ArrayList<Orders> list = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
//            pr.setInt(1, id);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
//                int id = resultSet.getInt("id");
//                int idAccount = resultSet.getInt("idAccount");
//                String address = resultSet.getString("address");
//                double transFee = resultSet.getDouble("transFee");
//                String payMethod = resultSet.getString("payMethod");
//                Date startDate = resultSet.getDate("startDate");
//                int status = resultSet.getInt("status");
//                Orders orders = new Orders(id, idAccount, address, transFee, payMethod, startDate, status);
                int id = resultSet.getInt("id");
                int userID = resultSet.getInt("userID");
                double totalPrice= resultSet.getDouble("totalPrice");
                String buyDate = resultSet.getString("buyDate");
                String status = resultSet.getString("status");
                String address = resultSet.getString("address");
                double shippingFee = resultSet.getDouble("shippingFee");
                String payment = resultSet.getString("payment");
                Orders orders = new Orders(id, userID, totalPrice, buyDate, status, address, shippingFee, payment);
                list.add(orders);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static Orders selectById(int orderID) {
        Orders orders = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int userID = resultSet.getInt("userID");
                double totalPrice= resultSet.getDouble("totalPrice");
                String buyDate = resultSet.getString("buyDate");
                String status = resultSet.getString("status");
                String address = resultSet.getString("address");
                double shippingFee = resultSet.getDouble("shippingFee");
                String payment = resultSet.getString("payment");
                orders = new Orders(id, userID, totalPrice, buyDate, status, address, shippingFee, payment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public static ArrayList<Order_details> listDetail(int orderID) {
        ArrayList<Order_details> list = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select id, orderID, productID, quantity, price, size from order_details where id =?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, orderID);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                orderID = resultSet.getInt("orderID");
                int productID = resultSet.getInt("productID");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String size = resultSet.getString("size");
                Order_details detail = new Order_details(id, orderID ,productID, quantity, price, size);
                list.add(detail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static synchronized int delOrder(int orderID) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pr = connection.prepareStatement( "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders where id =?");
            pr.setInt(1, orderID);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                pr = connection.prepareStatement("update orders where id =?");
                pr.setInt(1, 1);
                pr.setInt(2, orderID);
                re = pr.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static synchronized int delOrderCus(int orderID) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pr = connection.prepareStatement( "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders where id =?");
            pr.setInt(1, orderID);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                pr = connection.prepareStatement("update orders set hideCus =? where id =?");
                pr.setInt(1, 1);
                pr.setInt(2, orderID);
                re = pr.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static synchronized int updateStatus(int orderID, String status) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pr = connection.prepareStatement( "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders where id =?");
            pr.setInt(1, orderID);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                pr = connection.prepareStatement("update orders set status =? where id =?");
                pr.setString(1, status);
                pr.setInt(2, orderID);
                re = pr.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static ArrayList<Orders> getListByStatus(String st) {
        ArrayList<Orders> list = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders where status =?" ;
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, st);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int userID = resultSet.getInt("userID");
                double totalPrice= resultSet.getDouble("totalPrice");
                String buyDate = resultSet.getString("buyDate");
                String status = resultSet.getString("status");
                String address = resultSet.getString("address");
                double shippingFee = resultSet.getDouble("shippingFee");
                String payment = resultSet.getString("payment");
                Orders orders = new Orders(id, userID, totalPrice, buyDate, status, address, shippingFee, payment);
                list.add(orders);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static ArrayList<Orders> getListOfCus(int st,int hide, int idAcc) {
        ArrayList<Orders> list = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders where status =? and idAccount =? and hideCus =?" ;
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, st);
            pr.setInt(2, idAcc);
            pr.setInt(3, hide);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int userID = resultSet.getInt("userID");
                double totalPrice= resultSet.getDouble("totalPrice");
                String buyDate = resultSet.getString("buyDate");
                String status = resultSet.getString("status");
                String address = resultSet.getString("address");
                double shippingFee = resultSet.getDouble("shippingFee");
                String payment = resultSet.getString("payment");
                Orders orders = new Orders(id, userID, totalPrice, buyDate, status, address, shippingFee, payment);
                list.add(orders);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static ArrayList<Orders> searchByStartDate(Date d) {
        ArrayList<Orders> list = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select id, userID, totalPrice, buyDate, status, address, shippingFee, payment from orders where buyDate =?" ;
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setDate(1, d);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int userID = resultSet.getInt("userID");
                double totalPrice= resultSet.getDouble("totalPrice");
                String buyDate = resultSet.getString("buyDate");
                String status = resultSet.getString("status");
                String address = resultSet.getString("address");
                double shippingFee = resultSet.getDouble("shippingFee");
                String payment = resultSet.getString("payment");
                Orders orders = new Orders(id, userID, totalPrice, buyDate, status, address, shippingFee, payment);
                list.add(orders);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static int insertOrders(Orders in) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String date = new java.sql.Date(System.currentTimeMillis()).toString();
        String sql = "insert into orders(userID, totalPrice, buyDate, address, shippingFee, payment) " +
                "values(?,?,?,?,?,?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, in.getUserID());
            pr.setDouble(2, in.getTotalPrice());
            pr.setString(3, date);
            pr.setString(4, in.getAddress());
            pr.setDouble(5, in.getShippingFee());
            pr.setString(6, in.getPayment());
            re = pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static Orders latestOrders() {
        Orders orders = null;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select i.id, i.userID, i.totalPrice, i.buyDate, i.status, i.address, i.shippingFee, i.payment \n" +
                "                              from orders as i order by i.id DESC\n" +
                "limit 1";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userID = resultSet.getInt("userID");
                double totalPrice= resultSet.getDouble("totalPrice");
                String buyDate = resultSet.getString("buyDate");
                String status = resultSet.getString("status");
                String address = resultSet.getString("address");
                double shippingFee = resultSet.getDouble("shippingFee");
                String payment = resultSet.getString("payment");
                orders = new Orders(id, userID, totalPrice, buyDate, status, address, shippingFee, payment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public static int insertOrderDetail(Order_details idt) {
        int re = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into order_details(id, orderID, productID, quantity, price, size) " +
                "values(?,?,?,?,?,?)";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, idt.getId());
            pr.setInt(2, idt.getOrderID());
            pr.setInt(3, idt.getProductID());
            pr.setInt(4, idt.getQuantity());
            pr.setDouble(5, idt.getPrice());
            pr.setString(6, idt.getSize());
            re = pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
    public static int idBestSeller(){
        int productID = 0;
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "select d.productID, sum(d.quantity) as tong\n" +
                "                from order_details as d join orders as i on d.id = i.id \n" +
                "                where i.status NOT LIKE 'Canceled'\n" +
                "                group by d.productID \n" +
                "                order by tong DESC  \n" +
                "                limit 1;";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                productID = resultSet.getInt("productID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productID;
    }
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
