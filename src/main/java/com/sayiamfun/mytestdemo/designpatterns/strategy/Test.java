package com.sayiamfun.mytestdemo.designpatterns.strategy;

public class Test {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        int i = context.executeStrategy(6, 2);
        System.out.println(i);
        System.out.println("*****************************");
        context = new Context(new OperationSubstract());
        i = context.executeStrategy(6, 2);
        System.out.println(i);
        System.out.println("*****************************");
        context = new Context(new OperationMultiply());
        i = context.executeStrategy(6, 2);
        System.out.println(i);
        System.out.println("*****************************");
        context = new Context(new OperationDiv());
        i = context.executeStrategy(6, 2);
        System.out.println(i);
        System.out.println("*****************************");

    }

}
