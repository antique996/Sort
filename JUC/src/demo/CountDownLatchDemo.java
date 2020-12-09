package demo;

import java.util.concurrent.CountDownLatch;

/**
 * 计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "go out");
                countDownLatch.countDown();//-1
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();//等待归零,然后向下执行

        System.out.println("finish");
    }
}
