package com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory;

/// <summary>
/// 具体产品类： 跑车
/// </summary>
public class SportCar implements Car {


    @Override
    public void getCar() {
        System.out.println("场务把跑车交给范·迪塞尔");
    }

}
