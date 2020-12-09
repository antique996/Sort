package demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {

    public static void main(String[] args) {

        Ticket02 ticket02 = new Ticket02();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket02.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket02.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket02.sale();
            }
        }, "C").start();
    }
}

/**
 * 1.new ReentrantLock();
 * 2.lock.lock();//加锁
 * finally -> lock.unlock();//解锁
 */
class Ticket02 {

    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale() {

        lock.lock();//加锁

        try {
            //业务代码

            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票,剩余" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }

    }
}
