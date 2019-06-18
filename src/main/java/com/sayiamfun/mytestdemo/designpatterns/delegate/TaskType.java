package com.sayiamfun.mytestdemo.designpatterns.delegate;


public enum TaskType {

    ENCRYPTION(0,"加密"),LOGIN(1,"登录"),PUTAWAY(2,"上架");

    private Integer num;
    private String work;

    public String getWork() {
        return work;
    }

    private TaskType(Integer num, String work){
        this.num  = num;
        this.work = work;
    }
}
