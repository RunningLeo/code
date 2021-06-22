package com.cyf.code.easy;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 * "apple"
 * 示例 2:
 *
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 * 说明:
 *
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _524_通过删除字母匹配到字典里最长单词 {

    public static String findLongestWord(String s, List<String> d) {

        String maxSub = "";

        for (String t : d){

            boolean isSub = checkSubSeq(s, t);

            if(isSub){
                maxSub = getMaxString(maxSub, t);
            }
        }

        return maxSub;

    }


    /**
     * 判断t是否是s的子序列
     * @param s
     * @param t
     * @return
     */
    private static boolean checkSubSeq(String s, String t){

        if(t == null || t.length() == 0){
            return true;
        }

        int len1 = s.length();
        int len2 = t.length();

        int index1 = 0;
        int index2 = 0;

        while (index1 < len1){

            if(s.charAt(index1++) == t.charAt(index2)){
                index2++;
            }

            if(index2 == len2){
                return true;
            }
        }

        return index2 == len2;

    }


    /**
     * 获取最大的字符串
     * 1.长度大的大
     * 2.长度相同的，字典数小的大
     * @param a
     * @param b
     * @return
     */
    private static String getMaxString(String a, String b){

        int len1 = a.length();
        int len2 = b.length();

        if(len1 > len2){
            return a;
        }else if(len1 < len2) {
            return b;
        }else {
            //长度相同
            int i = 0;
            int j = 0;
            while (i < len1){
                if(a.charAt(i) == b.charAt(j)){
                    i++;
                    j++;
                    continue;
                }else {
                    return a.charAt(i) < b.charAt(j) ? a : b;
                }
            }
            return a;
        }

    }

    public static void main(String[] args) {

        String s = "abpcplea";
        List<String> list = Lists.newArrayList("a","b","c");

        String res = findLongestWord(s, list);

        System.out.println("===res="+res);

    }
}
