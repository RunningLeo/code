package com.cyf.code.jvm;

/**
 * @desc: 字节码
 * @Author: caoyafei
 * @Date: 2020/10/30 下午2:54
 */
public class Zijiema {

    public static void main(String[] args) {
        boolean flag = true;
        if (flag){
            System.out.println("Hello, Java!");
        }

        if (flag == true){
            System.out.println("Hello, JVM!");
        }
    }
}
