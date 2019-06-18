package com.sayiamfun.mytestdemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListNoSafe {
    public static void main(String[] args) {
//        List<String> list = new Vector<>();//解决方案1(不建议)
//        List<String> list = Collections.synchronizedList(new ArrayList<>());//解决方案2
//        List<String> list = new CopyOnWriteArrayList<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
//        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
//        Map<String,String> map1 = new ConcurrentHashMap<>();
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<Integer> list2 = list;
        ArrayList<Integer> list3 = (ArrayList<Integer>) list.clone();
        ArrayList<Integer> list4 = new ArrayList<>(list);
        list.stream().forEach(System.out::println);
        list2.stream().forEach(System.out::println);
        list3.stream().forEach(System.out::println);
        list4.stream().forEach(System.out::println);
        System.out.println("****************************");
        list.set(1,4);
        list.stream().forEach(System.out::println);
        list2.stream().forEach(System.out::println);
        list3.stream().forEach(System.out::println);
        list4.stream().forEach(System.out::println);
        System.out.println("****************************");
    }
}
