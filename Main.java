import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger LOG = Logger.getLogger(Main.class.getName());
        List<ParallelBruteForceSha256> threads;
        long salt = 100000000L;
        long start = 0L;
        long end = 0L;
        Obj obj = new Obj();

        while (true) {
            if (obj.getFound()) {
                System.out.println(obj.getKey());
                break;
            }

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t1 = new ParallelBruteForceSha256(start, end, obj);

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t2 = new ParallelBruteForceSha256(start, end, obj);

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t3 = new ParallelBruteForceSha256(start, end, obj);

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t4 = new ParallelBruteForceSha256(start, end, obj);

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t5 = new ParallelBruteForceSha256(start, end, obj);

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t6 = new ParallelBruteForceSha256(start, end, obj);

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t7 = new ParallelBruteForceSha256(start, end, obj);

            start = ++end;
            end += salt;
            ParallelBruteForceSha256 t8 = new ParallelBruteForceSha256(start, end, obj);

            threads = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8);

            threads.forEach(ParallelBruteForceSha256::start);

            threads.forEach(t -> {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    LOG.severe(e.getMessage());
                }
            });
        }
    }
}