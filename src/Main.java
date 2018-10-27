import java.io.IOException;
import java.util.Scanner;
/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = "11010111110000";
        String input2 = "10011";
        //checkSum checkSumSender = new checkSum();
        CRC crc = new CRC();
        int first = Integer.parseInt(input,2);
        int second = Integer.parseInt(input2,2);


        crc.divideLogic(input,input2);


        //crc.CRC(input, input2);
        //checkSumSender.Checksum(input);



    }
}
