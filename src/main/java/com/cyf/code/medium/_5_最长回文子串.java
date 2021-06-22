package com.cyf.code.medium;

/**
 * @desc: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @Author: caoyafei
 * @Date: 2020/9/8 上午10:17
 */
public class _5_最长回文子串 {


    public static String longestPalindrome(String s) {

        String res = "";

        for (int i = 0; i < s.length(); i++) {

            //
            String s1 = palindrome(s, i, i);

            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;

        }

        return res;
    }

    public static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if (r < l + 2) {
            return "";
        }

        return s.substring(l + 1, r);
    }


    public static void main(String[] args) {
        String s = "aacxycaa";
        String sub = longestPalindrome(s);

        System.out.println("==" + sub);

    }


}
