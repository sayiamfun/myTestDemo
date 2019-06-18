package com.sayiamfun.mytestdemo.designpatterns.singleton;

/**
 * 饿汉式实现单例模式
 */
public class SingletonHungry {

    private final static SingletonHungry INSTANCE = new SingletonHungry();

    private SingletonHungry(){}

    public static SingletonHungry getInstance(){
        return INSTANCE;
    }

}
