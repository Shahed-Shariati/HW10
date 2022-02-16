package Tamrin5;

public class DeadLock extends Thread{
    static Thread mainThread;
    @Override
    public void run() {
        System.out.println("Child thread waiting for  main thread completion");

            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        DeadLock thread = new DeadLock();
        DeadLock.mainThread = Thread.currentThread();
        thread.start();
        System.out.println("Main thread waiting for child thread completion");
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread execution complete");
    }
}
