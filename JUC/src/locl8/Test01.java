package locl8;

import java.util.concurrent.TimeUnit;

/**
 * 1.sms延迟1s,先发短信or打电话?
 */
public class Test01 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        //锁的存在
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();

        //捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.call();
        }, "B").start();
    }
}

class Phone {

    //syn锁的对象是方法的调用者
    //两个方法用的是同一个锁,谁先拿到谁先执行
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}
