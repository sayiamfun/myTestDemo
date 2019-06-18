package com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory;

public enum CarType {

    SPORTCAR(0,"跑车"),JEEPCAR(1,"越野车"),HATCHBACKCAR(2,"两厢车");

    private Integer num;
    private String car;

    public Integer getNum() {
        return num;
    }

    private CarType(Integer num, String car){
        this.num = num;
        this.car = car;
    }

}





