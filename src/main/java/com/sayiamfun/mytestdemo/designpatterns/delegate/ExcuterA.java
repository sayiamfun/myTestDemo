package com.sayiamfun.mytestdemo.designpatterns.delegate;

/**
 * @Project: spring
 * @description: 员工A执行某项命令
 * @ModificationHistory who      when       What
 **/
public class ExcuterA implements  IExcuter{

    @Override
    public void excute(String command) {
        System.out.println("员工A 开始做"+command+"的工作");
    }
}
