package com.cyf.code.easy;

import java.util.Arrays;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _680_验证回文字符串2 {

    static boolean del = false;

    public static boolean validPalindrome(String s) {

        if(s == null || s.length() <= 1){
            return true;
        }

        int len = s.length();

        int left = 0;
        int right = len - 1;

        char[] arr = s.toCharArray();

        while (left < right){

            if(arr[left] == arr[right]){
                left++;
                right--;
                continue;
            }

            if(del){
                return false;
            }

            del = true;

            return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left+1, right+1));

        }

        return true;

    }

    public static void main(String[] args) {

     //   String s = "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu";

        String s = "deeee";


        boolean flag = validPalindrome(s);

        System.out.println("===>flag="+flag);

        /**
         * cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu
         */

    }
}
