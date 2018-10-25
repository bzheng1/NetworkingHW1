import java.util.Scanner;
/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        checkSum checkSum = new checkSum();
        String results;
        results = checkSum.driver(input);
        System.out.print(results);

    }
}
