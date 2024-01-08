package entity;

public class Images {
    int id;
    int productID;
    String name;
    String path1;
    String path2;
    String path3;
    String path4;

    public Images(int id, int productID, String name, String path1, String path2, String path3, String path4) {
        this.id = id;
        this.productID = productID;
        this.name = name;
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.path4 = path4;
    }

    public Images() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath1() {
        return path1;
    }

    public void setPath1(String path1) {
        this.path1 = path1;
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }

    public String getPath3() {
        return path3;
    }

    public void setPath3(String path3) {
        this.path3 = path3;
    }

    public String getPath4() {
        return path4;
    }

    public void setPath4(String path4) {
        this.path4 = path4;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", productID=" + productID +
                ", name='" + name + '\'' +
                ", path1='" + path1 + '\'' +
                ", path2='" + path2 + '\'' +
                ", path3='" + path3 + '\'' +
                ", path4='" + path4 + '\'' +
                '}';
    }
}
