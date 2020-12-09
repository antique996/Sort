package bq;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        test02();
    }

    /**
     * 抛出异常
     */
    public static void test01() {
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //查看队首元素
        System.out.println(blockingQueue.element());

        System.out.println("===========");
        //抛出异常
        //System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //抛出异常
        //System.out.println(blockingQueue.remove());
    }

    /**
     * 有返回值,无异常
     */
    public static void test02() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //false
        //System.out.println(blockingQueue.offer("d"));

        //查看队首元素
        System.out.println(blockingQueue.peek());

        System.out.println("================");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //null
        //System.out.println(blockingQueue.poll());
    }

    /**
     * 等待,阻塞(一直阻塞)
     */
    public static void test03() throws InterruptedException {

        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

//        blockingQueue.put("d"); //一直阻塞
        System.out.println(blockingQueue.take());
    }

    /**
     * 超时等待
     */
    public static void test04() throws InterruptedException {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d", 2, TimeUnit.SECONDS);

        blockingQueue.poll(2, TimeUnit.SECONDS);
    }
}
