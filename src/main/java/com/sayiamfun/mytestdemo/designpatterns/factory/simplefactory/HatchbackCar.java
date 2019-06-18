package com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory;

/// <summary>
/// 具体产品类： 两箱车
/// </summary>
public class HatchbackCar implements Car{

    @Override
    public void getCar() {
        System.out.println("场务把两箱车交给范·迪塞尔");
    }
}
