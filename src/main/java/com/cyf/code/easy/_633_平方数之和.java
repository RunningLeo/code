package com.cyf.code.easy;

/**
 *给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 *
 * 示例2:
 *
 * 输入: 3
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _633_平方数之和 {

    public static boolean judgeSquareSum(int c) {

        if(c == 0 || c == 1){
            return true;
        }

        //首先对C开方
        int sqrt = (int)Math.sqrt(c) + 1;

        int left = 0;
        int right = sqrt;

        while (left <= right){

            int sum = left * left + right * right;

            if(sum > c){
                right--;
            }else if(sum < c){
                left++;
            }else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int c = 3;
        boolean flag = judgeSquareSum(c);

        System.out.println("===>flag="+flag);

    }
}
