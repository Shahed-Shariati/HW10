package Tamrin1;

public class MyThread extends Thread{

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {

                System.out.println("helllooo");

            }else {
                return;
            }
        }
    }
}
