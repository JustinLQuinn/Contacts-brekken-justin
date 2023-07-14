package contacts;
import java.util.Scanner;
public class Input {
    private final Scanner scanner;

    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(){
        return this.scanner.nextLine();
    }
    public Integer getInteger(){
       String b = this.scanner.nextLine();
        return Integer.parseInt(b);
    }

    public String getStringNumber(Integer number){
        return Integer.toString(number); 
     }
}
