import java.util.Scanner;

public class FibonacciSeries extends MyException {

    public FibonacciSeries(String str) {
        super(str);
       
    }
    public static int printFibonacci(int n){
        if(n == 1 ){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        return printFibonacci(n-1) + printFibonacci(n-2);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of term wants from series");
        try {
            int n = Integer.parseInt(sc.nextLine());
            sc.close();
            if(n<=0){
                throw new MyException("Value must be greater than 0.");
            }

        for(int i = 1; i <= n; i++){
            System.out.print(printFibonacci(i)+" ");
        }
        System.out.println();
        sc.close();
        } catch (MyException e ) {
            System.out.println(e);
        }
        catch(NumberFormatException ex){
            System.out.println("Enter only digits.");
        }
    }
}
