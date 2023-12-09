package bean;

public class OrderDetails {
    int id;
    int orderId;
    int productId;
    int quantity;
    int price;
    String size;

    public OrderDetails(int id, int orderId, int productId, int quantity, int price, String size) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }
    public OrderDetails(){}
}
