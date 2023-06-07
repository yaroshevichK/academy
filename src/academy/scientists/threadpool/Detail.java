package academy.scientists.threadpool;

import java.util.List;

import static academy.scientists.threadpool.Data.RANDOM;

public enum Detail {
    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_FOOT,
    FIGHT_FOOT,
    CPU,
    RAM,
    HDD;

    public static Detail getRandomDetail() {
        return Detail.values()[RANDOM.nextInt(Detail.values().length)];
    }

    public static Detail getRandomDetail(List<Detail> details) {
        if (details.isEmpty()) {
            return null;
        } else {
            return details.get(RANDOM.nextInt(details.size()));
        }
    }
}
