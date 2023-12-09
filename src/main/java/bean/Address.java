package bean;

public class Address {
    int id;
    String districts;
    String wards;
    String description;
    String recipientName;

    public Address(int id, String districts, String wards, String description, String recipientName) {
        this.id = id;
        this.districts = districts;
        this.wards = wards;
        this.description = description;
        this.recipientName = recipientName;
    }
    public Address(){
    }

}
