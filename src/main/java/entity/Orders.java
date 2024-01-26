package entity;

import java.util.ArrayList;

public class Orders {
    int id;
    int userID;
    double totalPrice;
    String buyDate;
    String status;
    String address;
    double shippingFee;
    String payment;
    private ArrayList<Order_details> details;

    public Orders() {
    }

    public Orders(int id, int userID, double totalPrice, String buyDate, String status, String address, double shippingFee, String payment) {
        this.id = id;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.buyDate = buyDate;
        this.status = status;
        this.address = address;
        this.shippingFee = shippingFee;
        this.payment = payment;
    }

    public Orders(int id, int userID, double totalPrice, String buyDate, String status, String address, double shippingFee, String payment, ArrayList<Order_details> details) {
        this.id = id;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.buyDate = buyDate;
        this.status = status;
        this.address = address;
        this.shippingFee = shippingFee;
        this.payment = payment;
        this.details = details;
    }

    public Orders(int i, int id, String address, int i1, String thanhToánKhiNhậnHàng, String s, String processing) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public ArrayList<Order_details> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Order_details> details) {
        this.details = details;
    }
    public double totalPrice() {
        double re =0;
        for (Order_details ivd: details) re += ivd.getPrice() * ivd.getQuantity();
        return re;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userID=" + userID +
                ", totalPrice=" + totalPrice +
                ", buyDate='" + buyDate + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", shippingFee=" + shippingFee +
                ", payment='" + payment + '\'' +
                '}';
    }
}
