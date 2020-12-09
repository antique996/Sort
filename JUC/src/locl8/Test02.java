package locl8;

import java.util.concurrent.TimeUnit;

/**
 * 增加一个普通方法,先sms or hello?  普通方法
 * 两个对象,两个同步方法
 */
public class Test02 {
    public static void main(String[] args) {
        //两个对象,两个调用者,两把锁
        Phone02 phone01 = new Phone02();
        Phone02 phone02 = new Phone02();

        new Thread(() -> {
            phone01.sendSms();
        }, "A").start();

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

class Phone02 {
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

    //不受锁的影响
    public void hello() {
        System.out.println("hello");
    }
}


