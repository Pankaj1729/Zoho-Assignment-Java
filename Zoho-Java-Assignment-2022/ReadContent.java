import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadContent {
    public static void main(String[] args) {
        BufferedReader reader;
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Entered the File name");
            String file = sc.nextLine();
            reader = new BufferedReader(new FileReader(file+".txt"));
            String line = reader.readLine();
            int lineNo = 1;
            while(line != null){
                System.out.println(lineNo+". "+line);
                lineNo++;
                line = reader.readLine();
            }
            System.out.println("File read Successfully!");
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
}
