package com.sayiamfun.mytestdemo.designpatterns.singleton;

/**
 * 静态内部类实现枚举类[推荐用]
 */
public class SingletonInnerClass {

    private SingletonInnerClass() {}

    private static class SingletonInstance {
        private static final SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        System.out.println("内部类被创建了");
        return SingletonInstance.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonInnerClass instance = SingletonInnerClass.getInstance();
    }
}
