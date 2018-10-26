import java.io.IOException;
import java.util.Scanner;
/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        checkSumSender checkSumSender = new checkSumSender();

        checkSumSender.Checksum(input);



    }
}
