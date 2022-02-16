package Tamrin1;

public class Main {
    public static void main(String[] args) {
     MyThread t = new MyThread();
     t.start();

        try {
            System.out.println("----------------------------------------------------------------------------------------------------------");
           Thread.sleep(2000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("intru------------------------------------------------------------------------------------");



    }
}
