import java.io.IOException;
import java.util.Scanner;
/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = "1101011111";
        String input2 = "10011";
        checkSum checkSumSender = new checkSum();
        CRC crc = new CRC();

        crc.CRC(input, input2);
        //checkSumSender.Checksum(input);



    }
}
