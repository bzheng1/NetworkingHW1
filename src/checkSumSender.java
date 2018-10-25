import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import static java.lang.Math.abs;


/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class checkSumSender {

    private Socket socket = null;
    private ServerSocket servsock = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;

    public Boolean checkInput(String input) {
        input = input.replaceAll("\\s+", "");
        boolean tf = input.matches("[01]+");
        return tf;
    }

    //puts string into String[]
    public String[] multi4correction(String input) {
        input = input.replaceAll("\\s+", "");
        //System.out.print(input);
        String[] inputArray = input.split("");
        //check
        int stringLength = input.length();
        int remainder = abs((stringLength % 4) - 4);
        if (remainder != 4) {
            remainder = stringLength + remainder;
            //System.out.print(padRightSpaces(input, remainder));
            inputArray = padRightSpaces(input, remainder).split("");
//            for(int i = 0; i<inputArray.length;i++){
//                System.out.print(inputArray[i]);
//            }
        }return inputArray;
    }


    public static String padRightSpaces(String str, int n) {
        return String.format("%1$-" + n +"s", str).replace(" ", "0");
    }

    //prepares String[] to be added
    public int[] sortArrayandAdd(String[] stringArray){
        int length = stringArray.length;
        int[] first = new int[length];
        int[] second = new int[length];
        int[] third = new int[length];
        int[] fourth = new int[length];
        int firsti = 0;
        int secondi = 0;
        int thirdi = 0;
        int fourthi = 0;

        for(int i = 0; i < stringArray.length; i++){
            if(i%4 == 0){
                first[firsti] = Integer.parseInt(stringArray[i]);
                firsti++;
            }if (i%4 == 1){
                second[secondi] = Integer.parseInt(stringArray[i]);
                secondi++;
            }if (i%4 == 2){
                third[thirdi] = Integer.parseInt(stringArray[i]);
                thirdi++;
            }if (i%4 == 3){
                fourth[fourthi] = Integer.parseInt(stringArray[i]);
                fourthi++;
            }

        }
        int[] checkSumArray = addMe(first,second,third,fourth);
        return checkSumArray;
    }

    public int[] addMe(int [] first, int[] second,int [] third, int [] fourth) {
        int[] finalResults = new int[4];
        int[] carryOnResults = addLogic(fourth, 0);
        finalResults[3] = carryOnResults[0];
        carryOnResults = addLogic(third,carryOnResults[1]);
        finalResults[2] = carryOnResults[0];
        carryOnResults = addLogic(second,carryOnResults[1]);
        finalResults[1] = carryOnResults[0];
        carryOnResults = addLogic(first,carryOnResults[1]);
        finalResults[0] = carryOnResults[0];

        if(carryOnResults[1] == 1){
            finalResults = addleftover(finalResults);
        }
        return flipTheBits(finalResults);
    }


    public int[] addLogic(int [] array, int remainder){
        int[] finalanswer = new int[2];
        int answer = 0;
        int carryover = 0;
        for(int i = 0; i < array.length; i++){
            answer += (array[i]);
        }
        answer += remainder;
        if(answer == 0){
            finalanswer[0] = answer;
            finalanswer[1] = carryover;
        }
        if(answer == 1){
            finalanswer[0] = answer;
            finalanswer[1] = carryover;
        }
        if(answer%2 == 0 && answer != 0){
            answer = 0;
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

    public int[] addleftover(int[] leftover){
        int remainder = 1;
        int carryover = 0;
        int[] finalchecksum = new int[4];
        for(int i = 3; i > -1;i--){
            finalchecksum[i]= leftover[i] + remainder + carryover;
            remainder = 0;
            if (finalchecksum[i] == 2){
                finalchecksum[i] = 0;
                carryover = 1;
            }else if(finalchecksum[i] == 3){
                finalchecksum[i] = 1;
                carryover = 1;
            }else if(finalchecksum[i]==1){
                carryover = 0;
            }
        }return finalchecksum;
    }

    public int[] flipTheBits(int[] finalCheckSum){
        for(int i = 0; i < finalCheckSum.length; i++){
            if(finalCheckSum[i]==1){
                finalCheckSum[i] = 0;
            }else if(finalCheckSum[i]==0){
                finalCheckSum[i] = 1;
            }
        }return finalCheckSum;
    }
    public String driver(String input){
        String msgtosend;
        if(checkInput(input)==false) {
            String incorrect = "Not a binary String";
            return incorrect;
        }
        String[] foobar = multi4correction(input);
        msgtosend = Arrays.toString(sortArrayandAdd(foobar));
        System.out.print("Output: " +input + " " +  msgtosend);
        return msgtosend;
    }
}


