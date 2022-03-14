import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            try (Socket socket = new Socket("127.0.0.1", 5001)) {
                Scanner sc1 = new Scanner(socket.getInputStream());
                System.out.println("Enter your Name: ");
                String message = sc.nextLine();

                //print on client machine
                PrintStream ps = new PrintStream(socket.getOutputStream());
                ps.println(message);

                //server respose 

                String reply = sc1.nextLine();
                System.out.println(reply);
                sc.close();
            }

            //to input on client machine


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
