import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class server {
   public static void main(String[] args) {
    try {
        ServerSocket socket = new ServerSocket(5000);

        System.out.println("Connected");

        //Take Input from user

        DataInputStream input = new DataInputStream(System.in);

    } catch (UnknownHostException e) {
        e.getStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
}

