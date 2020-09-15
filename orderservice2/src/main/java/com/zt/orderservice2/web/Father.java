package com.zt.orderservice2.web;

/**
 * @Classname Father
 * @Description TODO
 * @Date 2020/8/20 16:13
 * @Created by zhangtao
 */
public class Father  {
    static {
        System.out.println("111111");
    }
    {
        System.out.println("0000000");
    }
    public Father(){
        System.out.println("66666");
    }
    private String name = "zhangsan";
    private String  pao(){
        return "pao";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                '}';
    }

    public static String tiao(){
        return "tiao";
    }
}
