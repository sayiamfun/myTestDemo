package com.sayiamfun.mytestdemo.designpatterns.strategy;

public class OperationDiv implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        if (0 != num2) {
            return num1 / num2;
        }
        return num1;
    }
}
