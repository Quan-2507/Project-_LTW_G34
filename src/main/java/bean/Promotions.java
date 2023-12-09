package bean;

public class Promotions {
    int id;
    String name;
    String desciption;
    String imageUrl;

    public Promotions(int id, String name, String desciption, String imageUrl) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.imageUrl = imageUrl;
    }
    public Promotions(){}

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

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Promotions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desciption='" + desciption + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
