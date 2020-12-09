package pool;

import java.util.concurrent.*;

/**
 * Executors工具类,3大方法
 * 用线程池创建线程
 * new ThreadPoolExecutor.AbortPolicy()         //抛出异常
 * new ThreadPoolExecutor.CallerRunsPolicy()    //哪里来回哪里去
 * new ThreadPoolExecutor.DiscardPolicy()       //队列满了,丢掉任务,不抛出异常
 * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了,尝试和最早的竞争,也不会抛出异常
 */
public class Demo01 {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建一个固定的线程池大小
//        ExecutorService threadPool = Executors.newCachedThreadPool();//可伸缩的.遇强则强,遇弱则弱


        //最大线程如何定义
        //1.CPU密集型   几核,就是几,可以保持CPU的效率最高
        //2.IO密集型  大于 判断程序中十分耗IO的线程

        //查看CPU核数
        //System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());//队列满了,尝试和最早的竞争

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
