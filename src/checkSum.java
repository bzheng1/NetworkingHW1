import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Math.abs;
import static java.lang.Math.toDegrees;
import static sun.security.krb5.internal.LoginOptions.MAX;

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

    public char[] multi4correction(String input){
        int stringLength = input.length();
        int remainder = abs((stringLength % 4)-4);
        if (remainder != 4){
            remainder = stringLength + remainder;
            System.out.print(padRightSpaces(input,remainder));
            return padRightSpaces(input,remainder).toCharArray();
        }return input.toCharArray();
    }

    public static String padRightSpaces(String str, int n) {
        return String.format("%1$-" + n +"s", str).replace(' ', '0');
    }

    public char[] sortArray(char[] charArray){
        char[] first = new char[MAX];
        char[] second = new char[MAX];
        char[] third = new char[MAX];
        char[] fourth = new char[MAX];
        int firsti = 0;
        int secondi = 0;
        int thirdi = 0;
        int fourthi = 0;

        for(int i = 0; i < charArray.length; i++){
            if(4%i == 0){
                first[firsti] = charArray[i];
            }if (4%i == 1){
                second[secondi] = charArray[i];
            }if (4%i == 2){
                third[thirdi] = charArray[i];
            }if (4%i == 3){
                fourth[fourthi] = charArray[i];
            }firsti++;
            secondi++;
            thirdi++;
            fourthi++;
        }

    }

    public int[] addMe(char [] first, char[] second,char [] third, char [] fourth) {
        int remainder = 0;
        int[] results = new int[4];
        for(int i = 0; i < first.length; i++){
            results[0] += Character.getNumericValue(first[i]);
            if(results[0] == 0){
                results[0] = 0;
            }
            if(results[0]%2 == 0 && results[0] != 0){
                results[0] = 0;
                remainder = 1;
            }
        }
        for(int i = 0; i < second.length; i++){
            results[0] += Character.getNumericValue(second[i]) + remainder;
            if(results[0] == 0){
                results[0] = 0;
            }
            if(results[0]%2 == 0 && results[0] != 0){
                results[0] = 0;
                remainder = 1;
            }
        }
        return results;
    }


    public int[] addRest(char [] array, int remainder){
        int[] finalanswer = new int[2];
        int answer = 0;
        int carryover = 0;
        for(int i = 0; i < array.length; i++){
            answer += Character.getNumericValue(array[i]) + remainder;
        }
        if(answer == 0){
            finalanswer[0] = answer;
            finalanswer[1] = carryover;
        }
        if(answer%2 == 0 && answer != 0){
            finalanswer[0] = answer;
            carryover = 1;
            finalanswer[1] = carryover;

        }
        if(answer%2 == 1){
            answer = 1;

        }
    }

}


