package entity;

import java.util.Date;

public class Rates {
    int id;
    int star;
    int userID;
    Products productID;
    String comment;
    Date createAt;

    public Rates() {
    }

    public Rates(int id, int star, int userID, Products productID, String comment, Date createAt) {
        this.id = id;
        this.star = star;
        this.userID = userID;
        this.productID = productID;
        this.comment = comment;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Rates{" +
                "id=" + id +
                ", star=" + star +
                ", userID=" + userID +
                ", productID=" + productID +
                ", comment='" + comment + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
