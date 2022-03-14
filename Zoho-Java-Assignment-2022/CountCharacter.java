import java.util.Scanner;

public class CountCharacter {

    public static int countChar(String str){
        int count = 0;
        int i = 0;
        while(i<str.length()){
         
                count++;
        
            i++;
        }
        return count;

    }
    public static void main(String[] args) {
        int charCount = 0;
        //to use stdin use scanner class

        // f.addKeyListener(new KeyListener() {

        //     @Override
        //     public void keyTyped(KeyEvent e) { }
            
        //     @Override
        //     public void keyPressed(KeyEvent e) {
        //     if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
        //     System.out.println("woot!");
        //     }
        //     }
            
        //     @Override
        //     public void keyReleased(KeyEvent e) { }
            
        //     });

        Scanner sc = new Scanner(System.in);
           
            String str = sc.nextLine();
            charCount+= countChar(str);
            System.out.println("Number of Characters are: "+charCount);
       
        
        sc.close();
    }
}
