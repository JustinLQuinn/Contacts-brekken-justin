package contacts;

public class Contact {

    public String name;
    public Integer number;

    public Contact(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public Integer getNumber() {
        return number;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Integer number) {
       this.number = number;
    }

    @Override
    public String toString() {
        return name + "," + number;
    }


}
