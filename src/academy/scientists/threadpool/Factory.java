package academy.scientists.threadpool;


import java.util.concurrent.Callable;

import static academy.scientists.threadpool.Data.MAX_DETAILS;
import static academy.scientists.threadpool.Data.MIN_DETAILS;
import static academy.scientists.threadpool.Data.RANDOM;

public class Factory implements Callable<Integer> {
    private final Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public Integer call() {
        int countDetails = RANDOM.nextInt(MIN_DETAILS, MAX_DETAILS + 1);
        for (int j = 0; j < countDetails; j++) {
            dump.put();
        }
        return countDetails;
    }
}
