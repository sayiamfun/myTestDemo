package com.sayiamfun.mytestdemo;

public class SingleDemo {
    //volatile防止指令重排导致不安全问题
    private static volatile SingleDemo singleDemo = null;
    private SingleDemo(){
        System.out.println("SingleDemo的构造器......");
    }
    /*但是因为指令重排的原因,
      开辟内存之后并不一定能迅速初始化,
      但开辟内存之后singleDemo已经不为空,
      所以可能会得到一个并未初始化的singleDemo对象
      导致空指针问题
      所以声明singleDemo需要添加volatile
   */
    public static SingleDemo getSingleDemo(){
        if(null == singleDemo){
            synchronized(SingleDemo.class){
                if(null == singleDemo){
                    singleDemo = new SingleDemo();
                }
            }
        }
        return singleDemo;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                getSingleDemo();
            },String.valueOf(i)).start();
        }


    }
}
