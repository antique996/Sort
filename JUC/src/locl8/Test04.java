package locl8;

import java.util.concurrent.TimeUnit;

/**
 * 1.1个静态的同步方法,1个普通的静态方法,一个对象,先sms or call?
 * 2.1个静态的同步方法,1个普通的静态方法,两个对象,先sms or call?
 */
public class Test04 {
    public static void main(String[] args) {
        Phone04 phone1 = new Phone04();
        Phone04 phone2 = new Phone04();


        //锁的存在
        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();

        //捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

//Phone03 唯一的一个Class对象
class Phone04 {

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

    public synchronized void call() {
        System.out.println("打电话");
    }
}

