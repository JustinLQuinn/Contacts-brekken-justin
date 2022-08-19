package contacts;

public class Contact {
    private String name;
    private Integer number;


    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

//    public static Contacts createFromString(String personString) {
//        String [] parts = personString.split(":");
//        return new Contacts(parts[0].trim(), Integer.parseInt(parts[1].trim()));
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Contacts)) {
//            return false;
//        }
//        Contacts contact = (Contacts) obj;
//        return contact.name.equals(this.name) && contact.number.equals(this.number);
//    }

}

