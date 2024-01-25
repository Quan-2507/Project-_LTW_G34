package entity;

import java.io.Serializable;

public class Users implements Serializable {
    int id;
    String name;
    String userName;
    String email;
    int phoneNumber;
    String password;
    int role;
    String createAt;
    String lastUpdate;
    int addressID;
    int status;
    private VerifyAccount verifyAccount;

    public Users(Users u ){
        this.id = u.id;
        this.name = u.name;
        this.userName = u.userName;
        this.email = u.email;
        this.phoneNumber = u.phoneNumber;
        this.password = u.password;
        this.role = u.role;
        this.createAt = u.createAt;
        this.lastUpdate = u.lastUpdate;
        this.addressID = u.addressID;
        this.status = u.status;
        this.verifyAccount = u.verifyAccount;
    }
    public Users(int id, String name, String userName, String email, int phoneNumber, String password, int role, String createAt, String lastUpdate, int addressID, int status) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.addressID = addressID;
        this.status = status;
    }
    public Users(int id, String name, String userName, String email, int phoneNumber, String password, int role, String createAt, String lastUpdate, int addressID) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.addressID = addressID;
    }
    public Users(int id, String name, String userName, String email, int phoneNumber, String password,  String createAt, String lastUpdate, int addressID) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.addressID = addressID;
    }
    public Users( String name, String userName, String email, int phoneNumber, String password,  String createAt, String lastUpdate, int addressID) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.addressID = addressID;
    }
    public Users(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    public Users( String name, String userName, String email, int phoneNumber, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public VerifyAccount getVerifyAccount() {
        return verifyAccount;
    }

    public void setVerifyAccount(VerifyAccount verifyAccount) {
        this.verifyAccount = verifyAccount;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", createAt='" + createAt + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", addressID=" + addressID +
                ", status=" + status +
                '}';
    }
}
