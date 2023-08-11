
////construct new object and add it to an array list to hold contact object and then convert contact to string

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return "Name: " + name + ", Number: " + number;
    }
}


