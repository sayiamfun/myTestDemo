package com.sayiamfun.mytestdemo.thread;

import java.util.concurrent.CountDownLatch;


/**
 * 闭锁
 * 当所有的线程运行结束才可以运行主线程
 * 用途：可用于命令一组线程在同一个时刻开始执行某个任务，或者等待一组相关的操作结束。尤其适合计算并发执行某个任务的耗时。
 */
public class CountDownLatchTest {

    public void timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {

                    }

                }
            };
            t.start();
        }

        long start = System.nanoTime();
        System.out.println("打开闭锁");
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println("闭锁退出，共耗时" + (end - start));
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest test = new CountDownLatchTest();
        test.timeTasks(10, test.new RunnableTask());
    }

    class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("当前线程为：" + Thread.currentThread().getName());

        }
    }
}
