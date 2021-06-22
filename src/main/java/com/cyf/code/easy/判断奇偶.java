package com.cyf.code.easy;

/**
 * @desc: 给一个整数，判断奇偶
 * @Author: caoyafei
 * @Date: 2020/8/7 上午10:22
 */
public class 判断奇偶 {


    /**
     * 判断一个数是否是偶数
     * @param num
     * @return
     */
    public static boolean checkEven(int num) {
        return (num & 1) == 0;

    }

    public static void main(String[] args) {

        int a = 18;

        int b = -16;

        int c = 17;

        int d = -15;


        System.out.println("===>"+a+"是否是偶数:"+checkEven(a));
        System.out.println("===>"+b+"是否是偶数:"+checkEven(b));
        System.out.println("===>"+c+"是否是偶数:"+checkEven(c));
        System.out.println("===>"+d+"是否是偶数:"+checkEven(d));



    }
}
