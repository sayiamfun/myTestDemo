package com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory;

/// <summary>
/// 具体产品类： 越野车
/// </summary>
public class JeepCar implements Car{

    @Override
    public void getCar() {
        System.out.println("场务把越野车交给范·迪塞尔");
    }
}