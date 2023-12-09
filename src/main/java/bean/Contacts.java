package bean;

public class Contacts {
    int id;
    String name;
    String email;
    String title;
    String description;

    public Contacts(int id, String name, String email, String title, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.title = title;
        this.description = description;
    }
    public Contacts(){
    }
}
