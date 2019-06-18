package com.sayiamfun.mytestdemo.designpatterns.factory.abstractfactory;


public class AbstractTest {

    public static void main(String[] args) {
        MyFactory factory = new SportCarFactory();
        factory.createCar().getCar();
        factory.createSportBackpack().createBackPack();
    }
}
