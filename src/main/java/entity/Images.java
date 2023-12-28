package entity;

public class Images {
    int id;
    Products productID;
    String name;
    String path;

    public Images(int id, Products productID, String name, String path) {
        this.id = id;
        this.productID = productID;
        this.name = name;
        this.path = path;
    }

    public Images() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", productID=" + productID +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
