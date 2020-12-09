package forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 1.forkjoinpool通过它来执行
 * 2.计算任务forkjoinpool.execute(ForkJoinTask task)
 * 3.计算类要继承ForkJoinTask
 */
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {//forkjoin
            long mid = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            task1.fork();   //拆分任务,把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(mid + 1, end);
            task2.fork();   //拆分任务,把任务压入线程队列
            return task1.join() + task2.join();
        }
    }
}
