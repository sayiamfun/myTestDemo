package com.sayiamfun.mytestdemo.designpatterns.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: spring
 * @description: leader 委派者   任务分发的作用
 * @ModificationHistory who      when       What
 **/
public class Leader implements IExcuter {

    private Map<String, IExcuter> targets = new HashMap<String, IExcuter>();

    public Leader() {
        targets.put("加密", new ExcuterA());
        targets.put("登录", new ExcuterB());
        targets.put("上架", new ExcuterC());
    }

    @Override
    public void excute(String command) {
        for (TaskType value : TaskType.values()) {
            if(value.getWork().equals(command)){
                targets.get(command).excute(command);
                return;
            }
        }
        System.out.println(command+" 工作没有人做哦！！！快去招募新员工吧");
    }
}
