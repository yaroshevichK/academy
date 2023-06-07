package academy.scientists.threadpool;

import java.util.HashMap;
import java.util.concurrent.Callable;

import static academy.scientists.threadpool.Data.FIRST_DETAIL;
import static academy.scientists.threadpool.Data.MAX_DETAILS;
import static academy.scientists.threadpool.Data.MIN_DETAILS;
import static academy.scientists.threadpool.Data.RANDOM;

public class Scientist implements Callable<Integer> {

    private final Dump dump;
    private final HashMap<Detail, Integer> details = new HashMap<>();

    public Scientist(Dump dump) {
        this.dump = dump;
    }

    @Override
    public Integer call() {
        int countDetails = RANDOM.nextInt(MIN_DETAILS, MAX_DETAILS + 1);
        int count = 0;
        for (int j = 0; j < countDetails; j++) {
            Detail detail = dump.get();
            if (detail != null) {
                details.put(detail, details.containsKey(detail) ? details.get(detail) + 1 : FIRST_DETAIL);
                count++;
            }
        }
        return count;
    }

    public int getCountRobots() {
        return details
                .values()
                .stream()
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static void getWinner(Scientist scientist1, Scientist scientist2) {
        int countRobots1 = scientist1.getCountRobots();
        int countRobots2 = scientist2.getCountRobots();

        System.out.println(scientist1 + "\t" + countRobots1);
        System.out.println(scientist2 + "\t" + countRobots2);

        if (countRobots1 > countRobots2) {
            System.out.println("scientist1 " + " is winner!!!");
        } else if (countRobots1 < countRobots2) {
            System.out.println("scientist2 " + " is winner!!!");
        } else {
            System.out.println("No winner");
        }
    }
}
