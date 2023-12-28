package entity;

public class Orders {
    int id;
    Users userID;
    double totalPrice;
    String buyDate;
    String status;
    String address;
    double shippingFee;
    String payment;

    public Orders(int id, Users userID, double totalPrice, String buyDate, String status, String address, double shippingFee, String payment) {
        this.id = id;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.buyDate = buyDate;
        this.status = status;
        this.address = address;
        this.shippingFee = shippingFee;
        this.payment = payment;
    }

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
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
