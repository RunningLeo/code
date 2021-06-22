package com.cyf.code.medium;

import java.util.Stack;

/**
 * @author ：caoyafei
 * @Date ：Created in 18:08 2020-02-20
 * @Desc ：https://leetcode-cn.com/problems/remove-k-digits/
 */
public class _402_移掉K位数字 {


    public static String removeKdigits(String num, int k) {

        if (num == null || num == "") {
            return num;
        }

        Stack<Character> stack = new Stack<>();

        int len = num.length();

        if (k >= len) {
            return "0";
        }

        char[] chars = num.toCharArray();

        stack.push(chars[0]);

        int i = 1;


        while (i < len) {

            if (k != 0) {
                if (stack.isEmpty() || chars[i] >= stack.peek()) {
                    stack.push(chars[i]);
                    i++;
                } else {
                    stack.pop();
                    k--;
                }
            } else {
                stack.push(chars[i]);
                i++;
            }


        }


        StringBuilder minNum = new StringBuilder();

        Stack<Character> out = new Stack<>();

        while (!stack.isEmpty()) {
            if (k > 0) {
                stack.pop();
                k--;
                continue;
            }

            out.push(stack.pop());
        }

        while (!out.isEmpty()) {
            char n = out.pop();
            if (n == '0' && minNum.length() == 0) {
                continue;
            }
            minNum.append(n);

        }

        return minNum.length() > 0 ? minNum.toString() : "0";

    }

    public static void main(String[] args) {
        String num = "22222222222222222222222222222222222222";
        int k = 20;

        String min = removeKdigits(num, k);

        System.out.println("=====min=" + min);
    }
}
