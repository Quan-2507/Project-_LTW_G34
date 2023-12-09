package bean;

import java.sql.Timestamp;

public class ProductDetails {
    int id;
    int productId;
    String desciption;
    String size;
    int costPrice;
    int price;
    Timestamp createAt;
    Timestamp lastUpdate;

    public ProductDetails(int id, int productId, String desciption, String size, int costPrice, int price, Timestamp createAt, Timestamp lastUpdate) {
        this.id = id;
        this.productId = productId;
        this.desciption = desciption;
        this.size = size;
        this.costPrice = costPrice;
        this.price = price;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
    }
    public ProductDetails(){}
}
