package academy.scientists.future;


import java.util.HashMap;
import java.util.concurrent.Callable;

import static academy.scientists.future.Data.FIRST_DETAIL;
import static academy.scientists.future.Data.MAX_DETAILS;
import static academy.scientists.future.Data.MIN_DETAILS;
import static academy.scientists.future.Data.RANDOM;

public class Scientist implements Callable<HashMap<Detail, Integer>> {
    private final Dump dump;

    public Scientist(Dump dump) {
        this.dump = dump;
    }

    @Override
    public HashMap<Detail, Integer> call() {
        HashMap<Detail, Integer> details = new HashMap<>();
        int countDetails = RANDOM.nextInt(MIN_DETAILS, MAX_DETAILS + 1);
        int count = 0;
        for (int j = 0; j < countDetails; j++) {
            Detail detail = dump.get();
            if (detail != null) {
                details.put(detail, details.containsKey(detail) ? details.get(detail) + 1 : FIRST_DETAIL);
                count++;
            }
        }
        return details;
    }

    public static int getCountRobots(HashMap<Detail, Integer> details) {
        return details
                .values()
                .stream()
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static int getWinner(HashMap<Detail, Integer> details1, HashMap<Detail, Integer> details2) {

        Integer countRobots1 = getCountRobots(details1);
        Integer countRobots2 = getCountRobots(details2);

        System.out.println("scientist1" + "\t" + countRobots1);
        System.out.println("scientist2" + "\t" + countRobots2);

        return countRobots1.compareTo(countRobots2);
    }
}
