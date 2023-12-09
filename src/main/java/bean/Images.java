package bean;

public class Images {
    int id;
    int productId;
    String name;
    String path;

    public Images(int id, int productId, String name, String path) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.path = path;
    }
    public Images(){
    }
}
