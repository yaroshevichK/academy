package academy.scientists.threadpool;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static academy.scientists.threadpool.Data.COUNT_NIGHT;
import static academy.scientists.threadpool.Data.TIME_IN_NIGHT;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Dump dump = new Dump();

        Factory factory = new Factory(dump);
        Scientist scientist1 = new Scientist(dump);
        Scientist scientist2 = new Scientist(dump);

        List<Scientist> scientists = new ArrayList<>();
        scientists.add(scientist1);
        scientists.add(scientist2);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < COUNT_NIGHT; i++) {
            Collections.shuffle(scientists);
            System.out.println(" " + (i + 1) + " night");
            Thread.sleep(TIME_IN_NIGHT);

            executor.submit(factory);
            executor.invokeAll(scientists);
        }
        executor.shutdown();

        Scientist.getWinner(scientist1, scientist2);
    }
}
