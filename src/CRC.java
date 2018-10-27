import java.util.Arrays;

/**
 * @author Bryan Zheng
 * @version 10/25/2018.
 */
public class CRC {

    public String padFrame(String frame, String generator){
        int padAmt = frame.length() + (generator.length()-1);
        //adding zero to frame
        frame = padRightSpaces(frame,padAmt);
        System.out.print(padAmt + frame);
        return frame;
    }

    public int[] divideLogic(String frame, String generator){
        //int l=0;
        int[] frameIntArray = makeIntArray(frame);
        //11010
        int[] remainderArray = Arrays.copyOfRange(frameIntArray,0,generator.length());
        //10011
        int[] genIntArray = makeIntArray(generator);
        //00000
        int[] genIntZeroArray = new int[generator.length()];
        for(int i = 0; i <generator.length();i++){
            genIntZeroArray[i] = 0;
        }
        int trackOfFrame = generator.length();
        while(true){
            remainder()
        }


//        while(true) {
//            for (int i = 0; i < generator.length(); i++) {
//                remainderArray[l + i] = remainderArray[l + i] ^ Integer.parseInt(genArray[i]);
//            }
//            while (remainderArray[l] == 0 && l != remainderArray.length - 1) {
//                l++;
//            }
//            if ((remainderArray.length - l) < genArray.length) {
//                break;
//            }
//        }
//        return remainderArray;
    }

//    static int[] calculateCRC(int[] binaryString, int[])
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String padRightSpaces(String str, int n) {
        return String.format("%1$-" + n +"s", str).replace(" ", "0");
    }

    public int[] makeIntArray(String string){
        String[] stringArray = string.split("");
        int[] stringIntArray = new int[string.length()];
        for (int p = 0; p<string.length();p++){
            stringIntArray[p] = Integer.parseInt(stringArray[p]);
        }return stringIntArray;
    }

    public boolean isDivisible(int[] top, int[] bottom){
        String topString = Arrays.toString(top).replaceAll(",","").replaceAll(" ","").replaceAll("]","").substring(1);
        String bottomString = Arrays.toString(bottom).replaceAll(",","").replaceAll(" ","").replaceAll("]","").substring(1);
        int topInt = Integer.parseInt(topString,2);
        int bottomInt = Integer.parseInt(bottomString,2);
        if(topInt>bottomInt){
            //can divide by gen
            return true;
        }else return false;
    }

    int xor(int top, int bot){
        int x = top^bot;
        return x;
    }

    public int[] remainder(int[] top, int[] bot, int trackofFrame){
        for(int i = 0; i < bot.length; i++) {
            top[i] = xor(top[i], bot[i]);
        }testoutput(top);
        trackofFrame++;
        return top;
    }

    public void testoutput(int[] array){
        for(int i = 0; i <array.length;i++){
            System.out.print(array[i]);
        }
    }
}
