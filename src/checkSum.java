import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Math.abs;

/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class checkSum {

    private Socket socket = null;
    private ServerSocket servsock = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    public boolean checkInput(String input) {
        char[] inputArray = input.toCharArray();
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] == '0' || inputArray[i] == '1') {
                    //if 0 or 1 then return true.
                } else if (inputArray[i] != '0' && inputArray[i] != '1') {
                    //if not 0 or 1 return false.
                    return false;
                }
            }return true;
    }

    public String multi4correction(String input){
        int stringLength = input.length();
        int remainder = abs((stringLength % 4)-4);
        if (remainder != 4){
            remainder = stringLength + remainder;
            System.out.print(padRightSpaces(input,remainder));
            return padRightSpaces(input,remainder);
        }return input;
    }

    public static String padRightSpaces(String str, int n) {
        return String.format("%1$-" + n +"s", str).replace(' ', '0');
    }

    public char[] toArray(String input){
       return input.toCharArray();
    }
}


