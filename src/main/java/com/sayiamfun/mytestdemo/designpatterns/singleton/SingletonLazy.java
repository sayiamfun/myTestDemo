package com.sayiamfun.mytestdemo.designpatterns.singleton;

/**
 * 懒汉式实现单例模式
 * 线程不安全
 */
public class SingletonLazy {
    private static SingletonLazy singleton;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (singleton == null) {
            singleton = new SingletonLazy();
        }
        return singleton;
    }
}
