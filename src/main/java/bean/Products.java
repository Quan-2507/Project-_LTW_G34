package bean;

import java.sql.Timestamp;

public class Products {
    int id;
    String name;
    int categoryId;
    int status;

    public Products(int id, String name, int categoryId, int status) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.status = status;
    }
    public Products(){}
}
