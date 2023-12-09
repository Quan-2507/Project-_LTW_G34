package bean;

import java.sql.Timestamp;

public class PromotionDetails {
    int promotionId;
    int productId;
    double discount;
    Timestamp startDate;
    Timestamp expDate;

    public PromotionDetails(int promotionId, int productId, double discount, Timestamp startDate, Timestamp expDate) {
        this.promotionId = promotionId;
        this.productId = productId;
        this.discount = discount;
        this.startDate = startDate;
        this.expDate = expDate;
    }
    public PromotionDetails(){}
}
