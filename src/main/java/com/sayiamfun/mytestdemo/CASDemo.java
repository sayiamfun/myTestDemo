package com.sayiamfun.mytestdemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.getAndIncrement();
    }
    //解决ABA
    private static void makeABA() {
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);
        new Thread(()->{
            //睡眠,保证t2能拿到初始版本号
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1)+"\t"+Thread.currentThread().getName()+"\t"+atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1)+"\t"+Thread.currentThread().getName()+"\t"+atomicStampedReference.getStamp());
        },"t1").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            //睡眠,拿到版本号后等待t1执行完两次更新方法
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100, 101, stamp, atomicStampedReference.getStamp() + 1)+"\t"+Thread.currentThread().getName()+"\t"+atomicStampedReference.getStamp());
        },"t2").start();
    }

    private static void ABAException() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        new Thread(()->{
            System.out.println(atomicInteger.compareAndSet(100, 101)+"\t atomicInteger:"+atomicInteger);
            System.out.println(atomicInteger.compareAndSet(101, 100)+"\t atomicInteger:"+atomicInteger);
        },"t1").start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicInteger.compareAndSet(100, 201)+"\t atomicInteger:"+atomicInteger);
        },"t2").start();
    }


    //CAS
    private static void casDemo() {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        System.out.println(atomicInteger.compareAndSet(100, 101)+"\t atomicInteger:"+atomicInteger);
        System.out.println(atomicInteger.compareAndSet(100, 102)+"\t atomicInteger:"+atomicInteger);
    }
}
