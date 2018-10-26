/**
 * @author Bryan Zheng
 * @version 10/25/2018.
 */
public class CRC {

    public String CRC(String binaryString, String generator){
        int padAmt = binaryString.length() + (generator.length()-1);
        //adding zero to frame
        binaryString = padRightSpaces(binaryString,padAmt);
        System.out.print(padAmt + binaryString);
        return null;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String padRightSpaces(String str, int n) {
        return String.format("%1$-" + n +"s", str).replace(" ", "0");
    }

}
