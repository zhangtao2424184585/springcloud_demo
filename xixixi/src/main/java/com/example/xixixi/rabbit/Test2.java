package com.example.xixixi.rabbit;

import io.jsonwebtoken.lang.Collections;

import java.util.*;

/**
 * @Classname Test2
 * @Description TODO
 * @Date 2020/9/15 10:10
 * @Created by zhangtao
 */
public class Test2 {
    public static void main(String[] args) {
        Long time1 = new Date().getTime();
        String[] names = {"李杰", "李四","女神", "金鑫", "武佩奇", "李欣"};
//        List<String> list = Collections.arrayToList(names);
        List<String> list = Arrays.asList(names);
        List<String>newList = new ArrayList<>(list);
        ListIterator<String> stringListIterator = newList.listIterator();
        while (stringListIterator.hasNext()){
            String s = stringListIterator.next();
            if (s.startsWith("李")){
                stringListIterator.remove();
            }
        }
//        for (int i = 0; i < newList.size(); i++) {
//            if (newList.get(i).startsWith("李")){
//                newList.remove(i);
//            }
//        }
        System.out.println(new Date().getTime()-time1);
        System.out.println(newList);

    }
}
