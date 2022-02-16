package Tamrin4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;


public class Worker extends Thread {


    LinkedBlockingQueue<File> queue;
    private AtomicLong len = new AtomicLong(0);


    public Worker(LinkedBlockingQueue<File> queue) {

        this.queue = queue;

    }


    @Override
    public void run() {
        while (queue.size() >= 0) {
            File file = null;
            try {
                file = queue.remove();
                getSize( Paths.get(file.getAbsolutePath()));
            } catch (NoSuchElementException  e){
                System.out.print("");
                return;
            }

        }


    }


    public long getLength() {
        return this.len.get();
    }



    private  long getSize(Path path){
        try {
            len.addAndGet(Files.walk((Path) path)
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length())
                    .sum());
        }catch (IOException e){
            System.out.println(e);
        }

        return len.get();
    }


    private  long getFolderSize(File file) {

        File[] files = file.listFiles();
        for (File fil : files) {
            if (fil.isFile()) {

                len.addAndGet(fil.length());
            } else {

                len.addAndGet(getFolderSize(file));
            }


        }
        return len.get();

    }
}