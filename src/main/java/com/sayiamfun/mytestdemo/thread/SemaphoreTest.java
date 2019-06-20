package com.sayiamfun.mytestdemo.thread;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 主要用于对调用数量的控制
 * 用途：用来控制同时访问某个特定资源的操作数量，或者同时执行某个指定操作的数量。计数信号量可以用来实现某种资源池，或者对容器施加边界。
 *
 * @param <T>
 */
public class SemaphoreTest<T> {

    private final Set<T> set;

    private final Semaphore sema;

    public SemaphoreTest(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.sema = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sema.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                sema.release();
            }
        }
    }

    public boolean remove(T o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sema.release();
        }
        return wasRemoved;
    }

    public void print(){
        set.stream().forEach(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        boolean flag = true;
        int permits = 5;
        int elements = permits + 1;
//        int elements = permits;
        SemaphoreTest<Integer> test = new SemaphoreTest<Integer>(permits);
        for (int i = 0; i < elements; i++) {
            System.out.println("i = " + i);
            test.add(i);
            if (i > 3 && flag) {
                System.out.println("测试移除一个");
                test.remove(0);
                flag = false;
            }
        }
        System.out.println("********************");
        test.print();
    }
}
