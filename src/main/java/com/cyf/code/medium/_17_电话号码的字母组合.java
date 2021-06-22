package com.cyf.code.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: caoyafei
 * @Date: 2020/7/28 上午11:01
 */
public class _17_电话号码的字母组合 {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0){
            return res;
        }
        backtrack(res, digits, new StringBuilder());

        return res;
    }

    public void backtrack(List<String> res, String digits, StringBuilder sb) {

        int len = digits.length();

        if (len == 0) {
            res.add(sb.toString());
            return;
        }

        char [] chars = getChars(digits.charAt(0));

        for (char c : chars) {
            sb.append(c);

            backtrack(res, digits.substring(1, len), sb);

            // 回溯主要体现在这部分
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private char[] getChars(char c) {
        switch(c){
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[0];
        }
    }





    public static void main(String[] args) {

        String digits = "23";
        List<String> res = new _17_电话号码的字母组合().letterCombinations(digits);

        System.out.println("===>"+res.toString());

    }
}
