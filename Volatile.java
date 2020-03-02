import java.util.Scanner;

public class Volatile extends Thread {
    private volatile int  count=1;
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Running... "+ i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {


            }
            if (count == 0)
                break;
        }
    }
    void shutdown()
    {
        count=0;
    }

    public static void main(String[] args) {
        Volatile v1 = new Volatile();

        v1.start();
        Scanner scn= new Scanner(System.in);
        System.out.println("Press Enter to Stop!");
        scn.nextLine();
        v1.shutdown();
    }
}
