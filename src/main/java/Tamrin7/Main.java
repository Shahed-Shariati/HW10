package Tamrin7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService  = Executors.newFixedThreadPool(20);

        LinkedBlockingQueue<Person> people = new LinkedBlockingQueue<>(Arrays.asList(new Person("shahed","shariati"),
                new Person("Shoaib","Shariati"),
                new Person("Smarand","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Shahoo","Shariati"),
                new Person("Ahmad","Shariati")));
        Worker w1 = new Worker(people);
        for (int i = 0; i < 20; i++) {

            executorService.submit(w1);


        }

        executorService.shutdown();

    }
}
