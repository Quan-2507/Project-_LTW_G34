package bean;

import java.sql.Timestamp;

public class User {
    int id;
    String name;
    String userName;
    String email;
    int phoneNumber;
    int role;
    Timestamp createAt;
    Timestamp lastUpdate;
    int addressId;
    int status;

    public User(int id, String name, String userName, String email, int phoneNumber, int role, Timestamp createAt, Timestamp lastUpdate, int addressId, int status) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.addressId = addressId;
        this.status = status;
    }

    public User() {
    }
}
