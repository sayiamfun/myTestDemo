package com.sayiamfun.mytestdemo.designpatterns.template;

public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println(" Cricket name initialize !");
    }

    @Override
    void startPlay() {
        System.out.println(" start Cricket name !");
    }

    @Override
    void endPlay() {
        System.out.println(" Cricket name end !");
    }
}
