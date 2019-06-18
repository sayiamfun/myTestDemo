package com.sayiamfun.mytestdemo.designpatterns.factory.simplefactory;


public class CarFactory {

    public Car getCar(CarType carType)
    {
        switch (carType)
        {
            case SPORTCAR:
                return new SportCar();
            case JEEPCAR:
                return new JeepCar();
            case HATCHBACKCAR:
                return new HatchbackCar();
            default:
                try {
                    throw new Exception("爱上一匹野马,可我的家里没有草原. 你走吧！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
        }
    }
}
