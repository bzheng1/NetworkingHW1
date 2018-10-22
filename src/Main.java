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
        String inputs = checkSum.multi4correction(input);
        char array [] = checkSum.toArray(inputs);
        System.out.print(tf + inputs);
        for(int i = 0; i < array.length;i++){
            System.out.print(array[i]+"\n");
        }
    }
}
