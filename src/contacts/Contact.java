package contacts;

public class Contact {

    public String name;
    public String number;

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
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
       this.number = number;
    }

    //Add EditContact(array, object name) method --- add EditContact for the object
    // item itself.
    //1) ask user what field to edit; Name or Number
    //2) initiate Scanner
    //3) selection will call method; contact.setName or contact.setNumber
    //2) initiate Scanner to fill in setter
    //4) enter runs the setter with the Scanner field as the intended value for
    // the setter

}

