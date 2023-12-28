package entity;

public class Rates {
    int id;
    int star;
    int userID;
    int productID;
    String comment;
    String createAt;

    public Rates(int id, int star, int userID, int productID, String comment, String createAt) {
        this.id = id;
        this.star = star;
        this.userID = userID;
        this.productID = productID;
        this.comment = comment;
        this.createAt = createAt;
    }

    public Rates() {
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

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
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
                ", createAt='" + createAt + '\'' +
                '}';
    }
}
