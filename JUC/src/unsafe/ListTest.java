package unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {

        /**
         * 解决方案:
         * 1.vector
         * 2.Collection.synchronizedList(new ArrayList<>())
         * 3.new CopyOnWriteArrayList<>();
         *
         *CopyOnWrite写入时复制
         * 多个线程调用的时候,list,读取的时候,固定的,写入
         */

        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
