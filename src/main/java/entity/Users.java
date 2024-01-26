package entity;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
    int id;
    String name;
    String userName;
    String email;
    int phoneNumber;
    String password;
    int role;
    Date createAt;
    Date lastUpdate;
    String address;
    int status;
    String position;
    Date dateOfBirth;

    public Users() {
    }

    public Users(int id, String name, String userName, String email, int phoneNumber, String password, int role, Date createAt, Date lastUpdate, String address, int status, String position, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
        this.address = address;
        this.status = status;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
                ", createAt=" + createAt +
                ", lastUpdate=" + lastUpdate +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", position='" + position + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

