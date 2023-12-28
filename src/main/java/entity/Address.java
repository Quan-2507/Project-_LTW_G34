package entity;

public class Address {
    int id;
    String districts;
    String wards;
    String description;
    int recipientPhoneNumber;
    String RecipientName;

    public Address(int id, String districts, String wards, String description, int recipientPhoneNumber, String recipientName) {
        this.id = id;
        this.districts = districts;
        this.wards = wards;
        this.description = description;
        this.recipientPhoneNumber = recipientPhoneNumber;
        RecipientName = recipientName;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(int recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public String getRecipientName() {
        return RecipientName;
    }

    public void setRecipientName(String recipientName) {
        RecipientName = recipientName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", districts='" + districts + '\'' +
                ", wards='" + wards + '\'' +
                ", description='" + description + '\'' +
                ", recipientPhoneNumber=" + recipientPhoneNumber +
                ", RecipientName='" + RecipientName + '\'' +
                '}';
    }
}
