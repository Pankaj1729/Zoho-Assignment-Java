import java.io.*;
import java.util.*;

public class Question1{
    public static void main(String[] args) {

        try{

            //create object of file
            File obj = new File("ques1.txt");

            //DataOutputStream internally used fileOutputStream :- it require file object
            FileOutputStream fout = new FileOutputStream(obj);

            //Ctreate dataoutputstream object :- file stream object 
            DataOutputStream dout = new DataOutputStream(fout);

            //write Integer in the file :- writeInt()
            // for string :- writeUTF()
            //for boolean :- writeBoolean() 
            System.out.println("Enter number of integer wants to enter: ");
            Scanner sc =new Scanner(System.in);
            int n = sc.nextInt();
            while((n--)>0){
                int inp = sc.nextInt();
                dout.writeInt(inp);
            }
            fout.close();
            dout.close();
            sc.close();

            //Read the data using datainputstream

            FileInputStream fin = new FileInputStream(obj);
            DataInputStream din = new DataInputStream(fin);

            while(din.available() > 0){
                System.out.println(din.readInt());
            }
            fin.close();
            din.close();

        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
        

    }
}