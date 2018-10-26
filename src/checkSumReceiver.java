import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author Bryan Zheng
 * @version 10/25/2018.
 */
public class checkSumReceiver {
    checkSumSender checkSumSender = new checkSumSender();
    private Socket socket = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
}
