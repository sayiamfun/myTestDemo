package com.sayiamfun.mytestdemo.equals;

public class Equals {
    public static void main(String[] args) {
        //HashSet  判断是否重复使用的是equals方法
//        String s1 = new String("abc");
//        String s2 = new String("abc");
//        System.out.println(s1 == s2);//false
//        System.out.println(s1.equals(s2));//true
//        Set<String> set = new HashSet<>();
//        set.add(s1);
//        set.add(s2);
//        System.out.println(set.size());//1
//        System.out.println("====================================");
//        User user1 = new User("abc");
//        User user2 = new User("abc");
//        System.out.println(user1 == user2);//false
//        System.out.println(user1.equals(user2));//false
//        Set<User> set1 = new HashSet<>();
//        set1.add(user1);
//        set1.add(user2);
//        System.out.println(set1.size());//2

        Integer i1 = 123456789;
        Integer i2 = 123456789;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println((""+i1).equals(""+i2));


    }
}
