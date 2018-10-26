import static java.lang.Math.abs;


/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class checkSumSender {


    public Boolean checkInput(String input) {
        input = input.replaceAll("\\s+", "");
        boolean tf = input.matches("[01]+");
        return tf;
    }

    //puts string into String[]
    public String[] multi4correction(String input) {
        input = input.replaceAll("\\s+", "");
        //System.out.print(input);
        String[] inputArray = input.split("(?<=\\G....)");
        //check
        int stringLength = input.length();
        int remainder = abs((stringLength % 4) - 4);
        if (remainder != 4) {
            remainder = stringLength + remainder;
            //System.out.print(padRightSpaces(input, remainder));
            inputArray = padRightSpaces(input, remainder).split("(?<=\\G....)");
        }return inputArray;
    }


    public static String padRightSpaces(String str, int n) {
        return String.format("%1$-" + n +"s", str).replace(" ", "0");
    }

    //prepares String[] to be added return checksum in int[]
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
            //finalResults = addleftover(finalResults);
        }
        return finalResults;
        //return flipTheBits(finalResults);
    }


    public String addLogic(int [] array, int remainder){

            
            for(int i = 0; i <array.length; i++){

            }

            System.out.print(Integer.toBinaryString(sum));

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
    public int[] Checksum_Sender(String input) {
        int r = 0;

        if(checkInput(input)==false) {
            String incorrect = "Not a binary String";
        }
        String[] foobar = multi4correction(input);
        int[] checksumArray = sortArrayandAdd(foobar);
        int[] data = new int[foobar.length+4];
        for(int i = 0; i<foobar.length;i++){
            data[i] = Integer.parseInt(foobar[i]);
        }
        for(int p = foobar.length; p < data.length; p++){
            data[p] = checksumArray[r];
            r++;
        }
        System.out.print("Output: ");
        for(int q =0;q<data.length;q++){
            System.out.print(data[q]);
        }
        return data;
    }


}


