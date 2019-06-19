package com.sayiamfun.mytestdemo.designpatterns.template;

public class Football extends Game {
    @Override
    void initialize() {
        System.out.println(" Football game initialize !");
    }

    @Override
    void startPlay() {
        System.out.println(" start Football game !");
    }

    @Override
    void endPlay() {
        System.out.println(" Football name end !");
    }
}
