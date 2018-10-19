import static java.lang.Math.abs;

/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class checkSum {

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

        }
    }
}


