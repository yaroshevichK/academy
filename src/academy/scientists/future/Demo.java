package academy.scientists.future;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static academy.scientists.future.Data.COUNT_NIGHT;
import static academy.scientists.future.Data.FIRST_DETAIL;
import static academy.scientists.future.Data.TIME_IN_NIGHT;

public class Demo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Dump dump = new Dump();

        Factory factory = new Factory(dump);
        Scientist scientist1 = new Scientist(dump);
        Scientist scientist2 = new Scientist(dump);

        List<Scientist> scientists = new ArrayList<>();
        scientists.add(scientist1);
        scientists.add(scientist2);

        HashMap<Detail, Integer> detailsScientist1 = new HashMap<>();
        HashMap<Detail, Integer> detailsScientist2 = new HashMap<>();


        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < COUNT_NIGHT; i++) {
            Collections.shuffle(scientists);
            System.out.println(" " + (i + 1) + " night");
            Thread.sleep(TIME_IN_NIGHT);

            executor.submit(factory);
            List<Future<HashMap<Detail, Integer>>> results = executor.invokeAll(scientists);


            Future<HashMap<Detail, Integer>> newDetailsScientist1 = results.get(scientists.indexOf(scientist1));
            Future<HashMap<Detail, Integer>> newDetailsScientist2 = results.get(scientists.indexOf(scientist2));

            for (Map.Entry<Detail, Integer> pair : newDetailsScientist1.get().entrySet()) {
                if (detailsScientist1.containsKey(pair.getKey())) {
                    detailsScientist1.put(pair.getKey(), detailsScientist1.get(pair.getKey()) + pair.getValue());
                } else {
                    detailsScientist1.put(pair.getKey(), pair.getValue());
                }
            }

            for (Map.Entry<Detail, Integer> pair : newDetailsScientist2.get().entrySet()) {
                if (detailsScientist2.containsKey(pair.getKey())) {
                    detailsScientist2.put(pair.getKey(),detailsScientist2.get(pair.getKey()) + 1);
                } else {
                    detailsScientist2.put(pair.getKey(), FIRST_DETAIL);
                }
            }
        }

        executor.shutdown();

        int result = Scientist.getWinner(detailsScientist1, detailsScientist2);
        if (result > 0) {
            System.out.println(scientist1 + " is winner!!!");
        } else if (result < 0) {
            System.out.println(scientist2 + " is winner!!!");
        } else {
            System.out.println("No winner");
        }
    }
}
