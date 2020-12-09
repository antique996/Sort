package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new Thread(new Runnable()).start();
        //new Thread(new FutureTask<V>()).start();
        //new Thread(new FutureTask<V>(Callable)).start();

        MyThread myThread = new MyThread();
        FutureTask task = new FutureTask(myThread);//适配类

        new Thread(task, "A").start();
        new Thread(task, "B").start();//结果有缓存

        Integer o = (Integer) task.get();
        System.out.println(o);
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}
