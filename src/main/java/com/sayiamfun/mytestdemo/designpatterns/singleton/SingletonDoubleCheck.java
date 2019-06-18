package com.sayiamfun.mytestdemo.designpatterns.singleton;

/**
 * 懒汉式
 * 双重检查实现单例模式
 * 线程安全
 *
 */
public class SingletonDoubleCheck {

    /**
     * volatile为的是禁止指令重排
     */
    private static volatile SingletonDoubleCheck singleton;

    private SingletonDoubleCheck() {
    }

    public static SingletonDoubleCheck getInstance() {
        if (singleton == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (singleton == null) {
                    singleton = new SingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }

}
