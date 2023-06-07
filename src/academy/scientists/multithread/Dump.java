package academy.scientists.multithread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static academy.scientists.multithread.Data.FIRST_DETAIL;
import static academy.scientists.multithread.Data.START_COUNT_DETAILS;

public class Dump {
    private final HashMap<Detail, Integer> details = new HashMap<>();

    public Dump() {
        for (int i = 0; i < START_COUNT_DETAILS; i++) {
            Detail detail = Detail.getRandomDetail();
            details.put(detail, details.containsKey(detail) ? details.get(detail) + 1 : FIRST_DETAIL);
        }
    }

    public synchronized void put() {
        Detail detail = Detail.getRandomDetail();
        details.put(detail, details.containsKey(detail) ? details.get(detail) + 1 : FIRST_DETAIL);
    }

    public synchronized Detail get() {
        List<Detail> detailsInDamp = details
                .entrySet()
                .stream()
                .filter(pair -> pair.getValue() > 0)
                .map(Map.Entry::getKey)
                .toList();

        Detail detail = Detail.getRandomDetail(detailsInDamp);
        if (detail != null) {
            details.put(detail, details.get(detail) - 1);
        }
        return detail;
    }
}
