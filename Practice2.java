public class Practice2 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<100;i++)
        {
            System.out.println("Running "+ i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args)
    {
        Thread t1= new Thread(new Practice2());
        Thread t2 = new Thread(new Practice2());

        t1.start();
        t2.start();
    }
}
