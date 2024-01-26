package entity;

public class Order_details {
    int id;
    int orderID;
    int productID;
    int quantity;
    double price;
    String size;

    public Order_details(int id, int orderID, int productID, int quantity, double price, String size) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }

    public Order_details(int orderID, int productID, int quantity, double price, String size) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.size = size;
    }

    public Order_details() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Order_details{" +
                "id=" + id +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
