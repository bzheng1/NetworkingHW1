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
        checkSumSender.multi4correction(input);
        //System.out.print(input);
        //checkSumSender.Checksum_Sender(input);
//        String input0 = "0101";
//        String input1 = "0011";
//        String input2 = "1010";
//        String input3 = "0001";
//        String input4 = "1011";
//
//
//        int number0 = Integer.parseInt(input0, 2);
//        int number1 = Integer.parseInt(input1, 2);
//        int number2 = Integer.parseInt(input2, 2);
//        int number3 = Integer.parseInt(input3, 2);
//        int number4 = Integer.parseInt(input4, 2);
//
//        int sum = number0+number1+number2+number3+number4;
//        System.out.print(Integer.toBinaryString(sum));
    }
}
