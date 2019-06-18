package com.sayiamfun.mytestdemo;

public class VolatileDemo {
    public static void main(String[] args) {
        volatileNoAtomic();
    }
    //volatile的非原子性
    private static void volatileNoAtomic() {
        Mydata mydata = new Mydata();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    mydata.number++;
                }
            },"t1").start();
        }
        while(Thread.activeCount()>2){

        }
        System.out.println(mydata.number);
    }

    //volatile的可见性
    private static void volatileSee() {
        Mydata mydata = new Mydata();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t t1 Coming...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t addTo60...");
        },"t1").start();


        while(mydata.number == 0){

        }
        System.out.println("ending...");
    }
}

class Mydata{

    //int number = 0;//未使用volatile
    volatile int number = 0;//使用volatile

    public void addTo60(){
        this.number = 60;
    }
}
