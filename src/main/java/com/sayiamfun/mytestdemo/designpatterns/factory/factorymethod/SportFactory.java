package com.sayiamfun.mytestdemo.designpatterns.factory.factorymethod;

import com.sayiamfun.mytestdemo.designpatterns.factory.abstractfactory.SportBackpack;
import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.Car;
import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.SportCar;

/// <summary>
///  具体工厂类： 用于创建跑车类
/// </summary>
public class SportFactory implements MyFactory, com.sayiamfun.mytestdemo.designpatterns.factory.abstractfactory.MyFactory {

    @Override
    public Car createCar() {
        return new SportCar();
    }

    @Override
    public SportBackpack createSportBackpack() {
        return new SportBackpack();
    }
}
