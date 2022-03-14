//Is Prime or not
class Prime{
    boolean isPrime(int num){
        if(num == 1){
            return false;
        }
        int range = (int)Math.sqrt(num);
        for(int i = 2; i <= range; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}


// Prime Thread

class MyThread extends Thread{

    Prime obj;
    MyThread(Prime p){
        obj = p;
    }
     
    @Override
    public void run(){
      for(int i = 1; i <= 100; i++){
        if(obj.isPrime(i)){
              System.out.println(i+" is a Prime Number");
          }
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
}

public class PrimeThread {
    public static void main(String[] args) {
        System.out.println("Prime Numbers are: ");
        Prime newPrime = new Prime();

        MyThread newThread = new MyThread(newPrime);
        newThread.start();
    }
}

