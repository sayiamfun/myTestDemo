package com.sayiamfun.mytestdemo.designpatterns.factory.factorymethod;

import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.Car;
import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.JeepCar;

/// <summary>
///  具体工厂类： 用于创建越野车类
/// </summary>
public class JeepFactory implements MyFactory {

    @Override
    public Car createCar() {
        return new JeepCar();
    }
}
