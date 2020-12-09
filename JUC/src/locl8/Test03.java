package locl8;

import java.util.concurrent.TimeUnit;

/**
 * 增加两个同步方法,只有一个对象,先sms or call?
 * 两个对象, 增加两个同步方法,先sms or call?
 */
public class Test03 {
    public static void main(String[] args) {
        Phone03 phone = new Phone03();
        Phone03 phone02 = new Phone03();

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
            phone02.call();
        }, "B").start();
    }
}

//Phone03 唯一的一个Class对象
class Phone03 {

    //syn锁的对象是方法的调用者
    //static 静态方法
    //类一加载就有了,锁的是class
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }
}

