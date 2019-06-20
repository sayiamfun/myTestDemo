package com.sayiamfun.mytestdemo.thread;

import java.util.concurrent.*;

/**
 * 当主线程需要做一个耗时的计算时，可以启动一个子线程去处理，子线程处理同时主线程
 *
 * 做自己的事情，当主线程需要子线程的计算结果时候，则取出计算结果，如果这时候子线程
 *
 * 还没有处理完成，则主线程会处于等待状态
 */
public class FutureTest {

    public static void main(String[] args) {

        FutureTest.Work work = new FutureTest.Work();
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<Integer> result = service.submit(work);
        service.shutdown();

        try {

            Thread.sleep(3000);

            System.out.println(result.get()); //等待计算结果
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class Work implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {

            Thread.sleep(10000);
            return 10;//计算结果
        }
    }
}