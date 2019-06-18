package com.sayiamfun.mytestdemo.designpatterns.proxy.staticproxy;

public class ProxyTest {

    public static void main(String[] args) {
//        未使用代理类
        BuyHouse buyHouse = new BuyHouseImpl();
        buyHouse.buyHosue();
        System.out.println("**********************************************");
//        使用代理类
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buyHosue();
    }
}
