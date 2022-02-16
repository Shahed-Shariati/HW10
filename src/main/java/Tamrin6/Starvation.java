package Tamrin6;

public class Starvation extends Thread {
    static int threadCount = 1;
    @Override
    public void run() {
        System.out.println(threadCount + " st child thread execution starts");
        System.out.println( "child thread execution completes");
        threadCount++;
    }

    public static void main(String[] args) {
        System.out.println("Main thread execution starts");

        Starvation thread1 = new Starvation();
        thread1.setPriority(10);
        Starvation thread2 = new Starvation();
        thread2.setPriority(9);
        Starvation thread3 = new Starvation();
        thread3.setPriority(8);
        Starvation thread4 = new Starvation();
        thread4.setPriority(7);
        Starvation thread5 = new Starvation();
        thread5.setPriority(6);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Here thread5 have to wait because of the
        // other thread. But after waiting for some
        // interval, thread5 will get the chance of
        // execution. It is known as Starvation
        thread5.start();

        System.out.println("Main thread execution completes");


    }
}
