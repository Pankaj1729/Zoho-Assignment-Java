import java.util.*;

public class QueueImplementation {

    public static void enqueueItem(Vector<Integer> vectAsQueue, int val){
        vectAsQueue.add(val);
    }

    public static int dequeueItem(Vector<Integer> vectAsQueue){
        return vectAsQueue.remove(0);
    }

    public static void printItems(Vector<Integer> vectAsQueue){
        System.out.println("Elements are: ");
        for(int i = 0; i < vectAsQueue.size(); i++){
            System.out.print(vectAsQueue.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        //Vector Creation
        Scanner sc = new Scanner(System.in);

        Vector<Integer> vectAsQueue = new Vector<>();
        int flag = 1;

        while(flag == 1){
            System.out.println("1. Enqueue\n2. Dequeue\n3. List Items.\n4. Exit.");

        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();
        System.out.println();

        switch(choice){
            case 1: 
            System.out.println("Enter the value");
            int val = sc.nextInt();
            enqueueItem(vectAsQueue, val);
            System.out.println("Element add Successfullty!");
            break;

            case 2: 
            if(vectAsQueue.isEmpty()){
                System.out.println("Queue is Empty");
            }
            else{
                int curVal = dequeueItem(vectAsQueue);
                System.out.println("VAlue is: "+curVal);
            }
            break;

            case 3:
            if(vectAsQueue.isEmpty()){
                System.out.println("Queue is Empty");
            }

            else{
                printItems(vectAsQueue);
            }
            break;

            case 4:
            System.out.println("Program Ends!");
            flag = 0;
            break;

        }
        }
        sc.close();

    }
}
