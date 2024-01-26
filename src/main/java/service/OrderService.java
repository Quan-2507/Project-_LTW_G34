package service;

import dao.OrderDAO;
import entity.Categories;
import entity.Order_details;
import entity.Orders;
import dao.OrderDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class  OrderService{
    OrderDAO orderDao ;
    static OrderService instance;

    public OrderService() {
    }

    public List<Orders> get( ) {
        return orderDao.get();
    }

    public static OrderService getInstance() {
        if (instance == null)
            instance = new OrderService();
        return instance;
    }
    public ArrayList<Orders> listOrders() {
        ArrayList<Orders> list = OrderDAO.listOrders();
        for (Orders i : list) {
            i.setDetails(OrderDAO.listDetail(i.getId()));
        }
        return list;
    }
    public Orders selectById(int orderID) {
        Orders orders = OrderDAO.selectById(orderID);
        if (orders != null) {
            orders.setDetails(OrderDAO.listDetail(orderID));
        }
        return orders;
    }

    public int delInvoice(int idInvoice) {
        return OrderDAO.delOrder(idInvoice);
    }
    public int delInvoiceCus(int idInvoice) {
        return OrderDAO.delOrderCus(idInvoice);
    }

    public int updateStatus(int orderID, String status) {
        return OrderDAO.updateStatus(orderID, status);
    }
    public ArrayList<Orders> getListByStatus(String st) {
        ArrayList<Orders> list = OrderDAO.getListByStatus(st);
        for (Orders i : list) {
            i.setDetails(OrderDAO.listDetail(i.getId()));
        }
        return list;
    }
    public ArrayList<Orders> searchByStartDate(Date d) {
        ArrayList<Orders> list = OrderDAO.searchByStartDate(d);
        for (Orders i : list) {
            i.setDetails(OrderDAO.listDetail(i.getId()));
        }
        return list;
    }
    public ArrayList<Orders> getListOfCus(int st,int hide, int idAcc) {
        ArrayList<Orders> list = OrderDAO.getListOfCus(st, hide, idAcc);
        for (Orders i : list) {
            i.setDetails(OrderDAO.listDetail(i.getId()));
        }
        return list;
    }
    public int insertOrder(Orders in){
        return OrderDAO.insertOrders(in);
    }
    public Orders latestOrder() {
        return OrderDAO.latestOrders();
    }
    public int insertOrderDetail(Order_details idt){
        return OrderDAO.insertOrderDetail(idt);
    }
    public int idBestSeller(){return OrderDAO.idBestSeller();}
//    public void backQuantity(int id) {
//        Orders invoice = selectById(id);
//        for(Order_details i : invoice.getDetails()) {
//            ProductService.getInstance().updateQuantity(i.getProductID(), i.getQuantity());
//        }
//    }
}
