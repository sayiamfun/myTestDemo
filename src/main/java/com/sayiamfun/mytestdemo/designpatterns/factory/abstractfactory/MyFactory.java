package com.sayiamfun.mytestdemo.designpatterns.factory.abstractfactory;

import com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory.Car;

public interface MyFactory {

    Car createCar();

    SportBackpack createSportBackpack();
}
