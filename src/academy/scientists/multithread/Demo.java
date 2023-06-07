package academy.scientists.multithread;

public class Demo {
    public static final String FIRST_SCIENTIST = "Michele";
    public static final String SECOND_SCIENTIST = "Nick";
    public static final String FACTORY = "Factory";

    public static void main(String[] args) {
        Dump dump = new Dump();

        Factory factory = new Factory(FACTORY, dump);
        Scientist scientist1 = new Scientist(FIRST_SCIENTIST, dump);
        Scientist scientist2 = new Scientist(SECOND_SCIENTIST, dump);

        factory.start();
        scientist1.start();
        scientist2.start();

        try {
            factory.join();
            scientist1.join();
            scientist2.join();
        } catch (InterruptedException e) {

        }

        Scientist.getWinner(scientist1, scientist2);
    }
}
