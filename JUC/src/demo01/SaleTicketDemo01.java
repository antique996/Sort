package demo01;

/**
 * 属性,方法
 * 线程就是一个资源类,没有任何附属的操作
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}


//资源类
class Ticket {
    private int number = 60;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票,剩余" + number);
        }
    }
}
