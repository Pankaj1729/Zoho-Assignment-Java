import java.io.*;
import java.util.Scanner;

public class FileCloning {
    public static void main(String[] args) throws IOException{
        
        FileInputStream fin = null;
        FileOutputStream fout = null;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter file name from data you want: ");
            String fileIn = sc.nextLine();
            fin = new FileInputStream(fileIn);

            //create file object
            System.out.println("Enter file name where data stored");
            String fileOut = sc.nextLine();
            File obj = new File(fileOut);
            fout = new FileOutputStream(obj);

            int c;
            while((c = fin.read())!=-1){
                fout.write(c);
            }
            System.out.println("File cloned Successfully!");
            

        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
        catch (Exception e) {
            e.getStackTrace();
        }

        finally{
            if(fin != null){
                fin.close();
            }
            if(fout!=null){
                fout.close();
            }
            sc.close();
        }
    }
}
