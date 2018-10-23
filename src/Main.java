import java.util.Scanner;

/**
 * @author Bryan Zheng
 * @version 10/18/2018.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        checkSum checkSum = new checkSum();
        boolean tf = checkSum.checkInput(input);
        char [] inputs = checkSum.multi4correction(input);
        System.out.print(tf+"\n");
        for(int i = 0; i < inputs.length;i++){
            System.out.print(inputs[i]+"\n");
        }
    }
}
