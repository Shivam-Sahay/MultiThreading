public class Practice extends Thread{
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
        Practice p1 = new Practice();
        Practice p2 = new Practice();

        p1.start();
        p2.start();
    }
}