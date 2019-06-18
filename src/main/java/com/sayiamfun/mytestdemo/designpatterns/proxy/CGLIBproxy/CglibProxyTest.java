package com.sayiamfun.mytestdemo.designpatterns.proxy.CGLIBproxy;

import com.sayiamfun.mytestdemo.designpatterns.proxy.staticproxy.BuyHouse;
import com.sayiamfun.mytestdemo.designpatterns.proxy.staticproxy.BuyHouseImpl;

/**
 * CGLIB创建的动态代理对象比JDK创建的动态代理对象的性能更高，
 * 但是CGLIB创建代理对象时所花费的时间却比JDK多得多。
 * 所以对于单例的对象，因为无需频繁创建对象，用CGLIB合适，
 * 反之使用JDK方式要更为合适一些。
 * 同时由于CGLib由于是采用动态创建子类的方法，对于final修饰的方法无法进行代理。
 */
public class CglibProxyTest {

    public static void main(String[] args){
        BuyHouse buyHouse = new BuyHouseImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse);
        buyHouseCglibProxy.buyHosue();
    }
}
