package bean;

import java.sql.Timestamp;
import java.util.Date;

public class Orders {
    int id;
    int userId;
    int totalPrice;
    Timestamp buyDate;
    String status;
    String address;
    int shippingFee;
    String payment;

    public Orders(int id, int userId, int totalPrice, Timestamp buyDate, String status, String address, int shippingFee, String payment) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.buyDate = buyDate;
        this.status = status;
        this.address = address;
        this.shippingFee = shippingFee;
        this.payment = payment;
    }
    public Orders(){}
}
