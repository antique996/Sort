package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //forkJoin
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
//        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
//        Long sum = submit.get();
//
//        System.out.println(sum);

        // 并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000).parallel().reduce(0, Long::sum);
        System.out.println(sum);
    }


}
