package Tamrin4;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        File file = new File("H:\\Maktab Sharif");
        LinkedBlockingQueue<File> queueFiles = new LinkedBlockingQueue<>();

        File[] files =file.listFiles();
        int count = files.length;
        for (int i = 0; i < count ; i++) {
            queueFiles.offer(files[i]);
        }
        Worker w3 = new Worker(queueFiles);
        Worker w1 = new Worker(queueFiles);
        Worker w2 = new Worker(queueFiles);
        Worker w4 = new Worker(queueFiles);
        w1.setName("w1");
        w2.setName("w2");
        w3.start();
        w1.start();
        w2.start();
        w4.start();
        try {
            w1.join();
            w2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(w1.getLength() + w2.getLength() + w3.getLength() + w4.getLength() + " Bytes");
    }
}
