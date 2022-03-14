import java.util.Scanner;

public class MatrixMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int[][][] arr = new int[4][5][8];

        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 8; k++){
                    arr[i][j][k] = (int)(Math.random()*n);
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 8; k++){
                    System.out.print(arr[i][j][k]+" ");
                    if(maxValue < arr[i][j][k]){
                        maxValue = arr[i][j][k];
                    }

                    if(minValue > arr[i][j][k]){
                        minValue = arr[i][j][k];
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Maximum Value in Array is: "+maxValue);
        System.out.println("Minimum Value in Array is: "+minValue);
        sc.close();

        
    }
}
