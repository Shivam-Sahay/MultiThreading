import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SyncBlock {
    private int count=0;
    private Object obj1 = new Object();

     public static void main(String[] args) {
         SyncBlock syncBlock = new SyncBlock();
         syncBlock.dowork();
     }
     public void process()
     {
         synchronized (obj1) {
             for (int i = 0; i < 10000; i++) {
                 count++;
             }
         }
     }

     public void dowork()
     {
         Thread t1= new Thread(new Runnable() {
             @Override
             public void run() {
                 process();
             }
         });
         Thread t2= new Thread(new Runnable() {
             @Override
             public void run() {
                 process();
             }
         });

         t1.start();
         t2.start();

         try {
             t1.join();
             t2.join();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println(count);
     }
}
