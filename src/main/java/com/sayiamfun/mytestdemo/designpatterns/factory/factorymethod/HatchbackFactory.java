package com.sayiamfun.mytestdemo.designpatterns.factory.factorymethod;

import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.Car;
import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.HatchbackCar;

/// <summary>
///  具体工厂类： 用于创建两厢车类
/// </summary>
public class HatchbackFactory implements MyFactory{

    @Override
    public Car createCar() {
        return new HatchbackCar();
    }
}
