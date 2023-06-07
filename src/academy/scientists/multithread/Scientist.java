package academy.scientists.multithread;

import java.util.HashMap;

import static academy.scientists.multithread.Data.COUNT_NIGHT;
import static academy.scientists.multithread.Data.FIRST_DETAIL;
import static academy.scientists.multithread.Data.MAX_DETAILS;
import static academy.scientists.multithread.Data.MIN_DETAILS;
import static academy.scientists.multithread.Data.RANDOM;
import static academy.scientists.multithread.Data.TIME_IN_NIGHT;

public class Scientist extends Thread {

    private final Dump dump;
    private final HashMap<Detail, Integer> details = new HashMap<>();

    public Scientist(String name, Dump dump) {
        super(name);
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_NIGHT; i++) {
            try {
                sleep(TIME_IN_NIGHT);
            } catch (InterruptedException e) {
                break;
            }
            int countDetails = RANDOM.nextInt(MIN_DETAILS, MAX_DETAILS + 1);
            for (int j = 0; j < countDetails; j++) {
                Detail detail = dump.get();
                if (detail != null) {
                    details.put(detail, details.containsKey(detail) ? details.get(detail) + 1 : FIRST_DETAIL);
                }
            }
        }
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

        System.out.println(scientist1.getName() + "\t" + countRobots1);
        System.out.println(scientist2.getName() + "\t" + countRobots2);

        if (countRobots1 > countRobots2) {
            System.out.println(scientist1.getName() + " is winner!!!");
        } else if (countRobots1 < countRobots2) {
            System.out.println(scientist2.getName() + " is winner!!!");
        } else {
            System.out.println("No winner");
        }
    }
}
