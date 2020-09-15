package com.zt.orderservice2.web;

/**
 * @Classname Son
 * @Description TODO
 * @Date 2020/8/20 16:14
 * @Created by zhangtao
 */
public class Son extends Father {
    public Son(){
        System.out.println("222222");
    }
    {
        System.out.println("999999");
    }
    private String name = "lisi";

    @Override
    public String getName() {
        return name;
    }



    public String getFaterName(){
        return getName();
    }
    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.zt.orderservice2.web.Father");
    }
}
