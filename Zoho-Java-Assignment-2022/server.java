import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class server {
   public static void main(String[] args) {
    try {
        try (ServerSocket serSocket = new ServerSocket(5000)) {
            System.out.println("Connected!");


//accept client requests
            Socket ss = serSocket.accept();

            Scanner sc = new Scanner(ss.getInputStream());

            String requestMsg = sc.nextLine();

            String replyMsg = "Hi " + requestMsg; 

            //send msg
            PrintStream pt = new PrintStream(ss.getOutputStream());
            pt.println(replyMsg);
        }


    } catch (UnknownHostException e) {
        e.getStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
}

