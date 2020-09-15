package com.example.xixixi;

import java.util.Date;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/9/15 10:00
 * @Created by zhangtao
 */
public class Test {
    public static void main(String[] args) {
        Long time1 = new Date().getTime();
        String[] names = {"李杰", "李四","女神", "金鑫", "武佩奇", "李欣"};
        int count = 0;
        int nums = 0;
        for (int i = 0; i < names.length; i++) {
            char s1 = names[i].charAt(0);
            if (("" + s1).equals("李")) {
                count += 1;
                names[i] = null;
            }
        }
        String[] newNames = new String[names.length - count];
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                newNames[nums] = names[i];
                nums += 1;
            }
        }
        Long time2 = new Date().getTime();
        System.out.println(time2 - time1);
//        System.out.println(newNames);
        for (String newName : newNames) {
            System.out.println(newName);
        }
        for (String name : names) {
            name = null;
        }
    }
}

