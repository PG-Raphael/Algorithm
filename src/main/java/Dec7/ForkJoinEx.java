package Dec7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Raphael Yun on 12/7/2019
 */

public class ForkJoinEx {
    static final ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        long from = 1L, to = 100_000_000L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        Long result = (Long) pool.invoke(task);

        System.out.println("Elapsed time(4 core): "+(System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d = %d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis();
        for(long i = from; i<=to; i++)
            result +=i;
        System.out.println("Elapsed time(1 core): " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d = %d%n", from, to, result);
    }

    private static class SumTask extends RecursiveTask<Long> {
        long from, to;
        public SumTask(long from, long to) {
            this.from = from;
            this.to=to;
        }

        @Override
        protected Long compute() {
            long size = to - from +1;
            if(size<=5)
                return sum();
            long half = (from+to)/2;
            SumTask leftSum = new SumTask(from, half);
            SumTask rightSum = new SumTask(half+1, to);

            leftSum.fork();
            return rightSum.compute() + leftSum.join();
        }

        long sum() {
            long tmp = 0L;
            for(long i =from; i<=to;i++)
                tmp +=i;
            return tmp;
        }
    }
}
