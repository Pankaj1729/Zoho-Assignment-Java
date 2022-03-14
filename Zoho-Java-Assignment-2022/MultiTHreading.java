import java.util.Queue;
import java.util.LinkedList;

class QueueImplementation1 extends Prime {
    Queue<Integer> queue = new LinkedList<>();
    Prime obj = new Prime();

    void enqueue() {
        queue.add((int) (Math.random() * 1000));
    }

    void dequeue() {
        if (!queue.isEmpty()) {
            int val = queue.remove();
            if (obj.isPrime(val)) {
                System.out.println(val + " is Prime Number.");
            } else {
                System.out.println(val + " is not Prime Number.");
            }
        } else {
            System.out.println("Queue is Empty");
        }

    }
}

class Producer extends Thread {
    QueueImplementation1 obj;

    Producer(QueueImplementation1 queueImplement) {
        obj = queueImplement;
    }

    public void run() {
        obj.enqueue();
    }
}

class Consumer extends Thread {
    QueueImplementation1 obj;

    Consumer(QueueImplementation1 queueImplement) {
        obj = queueImplement;
    }

    @Override
    public void run() {
        obj.dequeue();
    }
}

class StarterThread extends Thread {
    QueueImplementation1 queueImplement = new QueueImplementation1();

    @Override
    public void run() {
        Producer obj1 = new Producer(queueImplement);
        Consumer obj2 = new Consumer(queueImplement);
        obj1.start();
        try {
            obj1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj2.start();
    }
}

public class MultiTHreading {
    public static void main(String[] args) throws InterruptedException {
        StarterThread startThread = new StarterThread();

        startThread.start();
        // QueueImplementation1 queueImplement = new QueueImplementation1();
        
        // queueImplement.enqueue();
        // queueImplement.dequeue();
        

    }
}
