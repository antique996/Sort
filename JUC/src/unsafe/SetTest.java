package unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
    public static void main(String[] args) {

        /**
         * 1.new CopyOnWriteArraySet<>();
         * 2.Collections.synchronizedSet(new HashSet<>());
         */

        Set<String> set = new CopyOnWriteArraySet<>();
        //Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
