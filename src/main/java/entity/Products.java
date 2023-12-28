package entity;

import java.util.Date;
import java.util.Objects;

public class Products {
    int id;
    String name;
    Categories category;
    int status;
    String description;
    String size;
    int costPrice;
    int price;
    String images;
    Date createAt;
    Date lastUpdate;

    public Products() {
    }

    public Products(int id) {
        this.id = id;
    }

    public Products(int id, String name, Categories category, int status, String description, String size, int costPrice, int price,String images, Date createAt, Date lastUpdate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.description = description;
        this.size = size;
        this.costPrice = costPrice;
        this.price = price;
        this.images= images;
        this.createAt = createAt;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", costPrice=" + costPrice +
                ", price=" + price +
                ", images='" + images + '\'' +
                ", createAt=" + createAt +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public Categories getCategory() {
        return category;
    }

    public String getImage() {
        return images;
    }

    public void setImage(String image) {
        this.images = image;
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

    public Categories getcategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id && category == products.category && status == products.status && Objects.equals(name, products.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, status);
    }
}
