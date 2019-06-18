package com.sayiamfun.mytestdemo.designpatterns.factory.abstractfactory;

public class SportBackpack  implements SportBackpackFactory{

    @Override
    public void createBackPack() {
        System.out.println("背起了LV小皮包");
    }
}
