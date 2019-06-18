package com.sayiamfun.mytestdemo.designpatterns.singleton;

/**
 * 枚举类实现单例模式
 */
public enum  SingletonEnumerate {
    INSTANCE;
    public void whateverMethod() {}

    public static void main(String[] args) {
        SingletonEnumerate singletonEnumerate1 = SingletonEnumerate.INSTANCE;
        SingletonEnumerate singletonEnumerate2 = SingletonEnumerate.INSTANCE;
        System.out.println(singletonEnumerate1 == singletonEnumerate2);

    }
}
