package pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 指定唤醒
 */
public class C {

    public static void main(String[] args) {

        DataC dataC = new DataC();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                dataC.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                dataC.printB();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                dataC.printC();
            }
        }, "C").start();
    }
}

class DataC {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private int num = 1;


    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "AAAAA");
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "BBBBB");
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "CCCCC");
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
