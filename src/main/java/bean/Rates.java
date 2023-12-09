package bean;

import java.sql.Time;
import java.sql.Timestamp;

public class Rates {
    int id;
    int star;
    int userId;
    int productId;
    String comment;
    Timestamp createAt;

    public Rates(int id, int star, int userId, int productId, String comment, Timestamp createAt) {
        this.id = id;
        this.star = star;
        this.userId = userId;
        this.productId = productId;
        this.comment = comment;
        this.createAt = createAt;
    }
    public Rates(){}
}
