package com.sayiamfun.mytestdemo.designpatterns.factory.abstractfactory;

import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.Car;
import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.SportCar;

public class SportCarFactory implements MyFactory{
    @Override
    public Car createCar() {
        return new SportCar();
    }

    @Override
    public SportBackpack createSportBackpack() {
        return new SportBackpack();
    }
}
