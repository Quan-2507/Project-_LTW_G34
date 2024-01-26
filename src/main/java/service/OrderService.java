package service;

import dao.OrderDao;
import dao.ProductDAO;
import entity.Orders;

import java.util.List;

public class OrderService {

    OrderDao orderDao ;

    public OrderService() {
        this.orderDao = new OrderDao();
    }

    public List<Orders> get( ) {
        return orderDao.get();
    }
}
