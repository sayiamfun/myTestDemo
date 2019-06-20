package com.sayiamfun.mytestdemo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 * 栅栏
 * 当所有线程到达指定位置后才能继续下一步动作
 * 用途：用于阻塞一组线程直到某个事件发生。所有线程必须同时到达栅栏位置才能继续执行下一步操作，且能够被重置以达到重复利用。
 * 而闭锁是一次性对象，一旦进入终止状态，就不能被重置。
 * 与闭锁的区别：
 * 闭锁用于等待事件
 * 栅栏用于等待线程
 */
public class CyclicBarrierTest {

    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CyclicBarrierTest() {

        /**
         * 获取你本机处理器虚拟机的最大数量
         */
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count,
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("所有线程均到达栅栏位置，开始下一轮计算");
                    }

                });
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(i);
        }
    }

    private class Worker implements Runnable {

        int i;

        public Worker(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            for (int index = 1; index < 3; index++) {
                System.out.println("线程" + i + "第" + index + "次到达栅栏位置，等待其他线程到达");
                try {
                    //注意是await,而不是wait
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

    }

    public void start() {
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }
    }

    public static void main(String[] args) {
        new CyclicBarrierTest().start();
    }
}
