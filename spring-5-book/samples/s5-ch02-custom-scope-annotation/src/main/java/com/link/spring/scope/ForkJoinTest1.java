package com.link.spring.scope;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: linK
 * @Date: 2022/7/12 10:54
 * @Description TODO
 */
public class ForkJoinTest1 {
    public static void main(String[] args) throws Exception {
        // 创建2000个随机数组成的数组:
        long[] array = new long[10000000];
        long startTimeDefault = System.currentTimeMillis();
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        long endTimeDefault = System.currentTimeMillis();
        System.out.println("Expected sum: " + expectedSum + " in " + (endTimeDefault - startTimeDefault) + "ms.");
        // fork/join:
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        // 公共线程池
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
        //Expected sum: 49993737190 in 103ms.     主线程统计
        //split 0~10000000 ==> 0~5000000, 5000000~10000000
        //split 0~5000000 ==> 0~2500000, 2500000~5000000
        //split 5000000~10000000 ==> 5000000~7500000, 7500000~10000000
        //split 0~2500000 ==> 0~1250000, 1250000~2500000
        //split 5000000~7500000 ==> 5000000~6250000, 6250000~7500000
        //split 0~1250000 ==> 0~625000, 625000~1250000
        //split 7500000~10000000 ==> 7500000~8750000, 8750000~10000000
        //split 2500000~5000000 ==> 2500000~3750000, 3750000~5000000
        //split 5000000~6250000 ==> 5000000~5625000, 5625000~6250000
        //split 6250000~7500000 ==> 6250000~6875000, 6875000~7500000
        //split 8750000~10000000 ==> 8750000~9375000, 9375000~10000000
        //split 3750000~5000000 ==> 3750000~4375000, 4375000~5000000
        //split 7500000~8750000 ==> 7500000~8125000, 8125000~8750000
        //split 2500000~3750000 ==> 2500000~3125000, 3125000~3750000
        //split 1250000~2500000 ==> 1250000~1875000, 1875000~2500000
        //result = 3128611277 + 3124361177 ==> 6252972454
        //result = 3125088720 + 3122154091 ==> 6247242811
        //result = 3126813053 + 3124970475 ==> 6251783528
        //result = 3127432264 + 3128036366 ==> 6255468630
        //result = 6251783528 + 6252972454 ==> 12504755982
        //result = 3123987169 + 3121316021 ==> 6245303190
        //result = 3124144867 + 3123267657 ==> 6247412524
        //result = 6255468630 + 6245303190 ==> 12500771820
        //result = 3122753876 + 3125017866 ==> 6247771742
        //result = 3125691736 + 3120090575 ==> 6245782311
        //result = 6247412524 + 6247242811 ==> 12494655335
        //result = 6245782311 + 6247771742 ==> 12493554053
        //result = 12504755982 + 12494655335 ==> 24999411317
        //result = 12493554053 + 12500771820 ==> 24994325873
        //result = 24994325873 + 24999411317 ==> 49993737190
        //Fork/join sum: 49993737190 in 42 ms.   并行执行后

    }

    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }
}

class SumTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 1000000;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    /**
     * 此任务执行的主要计算
     *
     * @return
     */
    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
                // 故意放慢计算速度:
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                }
            }
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        // 拆分步骤
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        // 调用所有
        invokeAll(subtask1, subtask2);
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}
