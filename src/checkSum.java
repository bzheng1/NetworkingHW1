import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Math.abs;
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
    public String[] checkInput(String input) {
        String[] inputArray = input.split("");
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] == "0" || inputArray[i] == "1") {
                    //if 0 or 1 then return true.
                } else if (inputArray[i] != "0" && inputArray[i] != "1") {
                    //if not 0 or 1 return false.
                    return null;
                }
            }return inputArray;
    }

    public String[] multi4correction(String input) {
        String[] inputArray = checkInput(input);
        //check
        if (inputArray != null) {
            int stringLength = input.length();
            int remainder = abs((stringLength % 4) - 4);
            if (remainder != 4) {
                remainder = stringLength + remainder;
                System.out.print(padRightSpaces(input, remainder));
                inputArray = padRightSpaces(input, remainder).split("");
                return inputArray;
            }
        }return inputArray;
    }


    public static String padRightSpaces(String str, int n) {
        return String.format("%1$-" + n +"s", str).replace(" ", "0");
    }

    public int[] sortArray(String[] charArray){
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
        int[] checkSumArray = addMe(first,second,third,fourth);
        return checkSumArray;
    }

    public int[] addMe(char [] first, char[] second,char [] third, char [] fourth) {
        int[] finalResults = new int[4];
        int[] carryOnResults = addLogic(first, 0);
        finalResults[0] = carryOnResults[0];
        carryOnResults = addLogic(second,carryOnResults[1]);
        finalResults[1] = carryOnResults[0];
        carryOnResults = addLogic(third,carryOnResults[1]);
        finalResults[2] = carryOnResults[0];
        carryOnResults = addLogic(fourth,carryOnResults[1]);
        finalResults[3] = carryOnResults[0];

        if(carryOnResults[1] == 1){
            //addLogic(finalResults,1);
        }
        return finalResults;
    }


    public int[] addLogic(char [] array, int remainder){
        int[] finalanswer = new int[2];
        int answer = 0;
        int carryover = 0;
        for(int i = 0; i < array.length; i++){
            answer += Character.getNumericValue(array[i]);
        }
        answer =+ remainder;

        if(answer == 0){
            finalanswer[0] = answer;
            finalanswer[1] = carryover;
        }
        if(answer == 1){
            finalanswer[0] = answer;
            finalanswer[1] = carryover;
        }
        if(answer%2 == 0 && answer != 0){
            finalanswer[0] = answer;
            carryover = 1;
            finalanswer[1] = carryover;

        }
        if(answer%2 == 1 && answer != 1){
            answer = 1;
            carryover = 1;
            finalanswer[0] = answer;
            finalanswer[1] = carryover;
        }return finalanswer;
    }

}


