package academy.scientists.multithread;

import static academy.scientists.multithread.Data.COUNT_NIGHT;
import static academy.scientists.multithread.Data.MAX_DETAILS;
import static academy.scientists.multithread.Data.MIN_DETAILS;
import static academy.scientists.multithread.Data.RANDOM;
import static academy.scientists.multithread.Data.TIME_IN_NIGHT;

public class Factory extends Thread {
    private final Dump dump;

    public Factory(String name, Dump dump) {
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
                dump.put();
            }
        }
    }
}
