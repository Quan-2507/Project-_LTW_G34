package entity;

public class Promotion_Details {
    Promotions promotionID;
    Products productID;
    double discount;
    String startDate;
    String expDate;

    public Promotion_Details(Promotions promotionID, Products productID, double discount, String startDate, String expDate) {
        this.promotionID = promotionID;
        this.productID = productID;
        this.discount = discount;
        this.startDate = startDate;
        this.expDate = expDate;
    }

    public Promotion_Details() {
    }

    public Promotions getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(Promotions promotionID) {
        this.promotionID = promotionID;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "Promotion_Detail{" +
                "promotionID=" + promotionID +
                ", productID=" + productID +
                ", discount=" + discount +
                ", startDate='" + startDate + '\'' +
                ", expDate='" + expDate + '\'' +
                '}';
    }
}
