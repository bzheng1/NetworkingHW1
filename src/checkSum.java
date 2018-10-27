import static java.lang.Math.abs;


/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class checkSum {


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


    public String getCheckSum(String [] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Integer.parseInt(array[i], 2);
        }
        String results = Integer.toBinaryString(sum);

        if (results.length() > 4) {
            results = results.substring(1);
            sum = Integer.parseInt(results, 2);
            sum += 1;
        }
        results = Integer.toBinaryString(flipBits(sum,4));
        if (results.length() < 4) {
            results = String.format("%1$" + 4 + "s", results).replace(" ", "0");;
        }
        return results;
    }

        public int flipBits(int n, int k) {
         int mask = (1 << k) - 1;
        return n ^ mask;
        }

        public String Checksum (String input){
            if(checkInput(input)==true){
                String checksum = getCheckSum(multi4correction(input));
                if(checksum.equals("0000")){
                    System.out.print("There were no errors.\nOutput: ");
                }else{
                    System.out.print("Output: ");
                }
                System.out.print(input + " " + checksum);
                return getCheckSum(multi4correction(input));
            }else return null;
        }
    }


