package demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //加到7
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("finish");
        });

        for (int i = 1; i <= 7; i++) {
            final int temp = i;

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(temp)).start();
        }
    }
}
