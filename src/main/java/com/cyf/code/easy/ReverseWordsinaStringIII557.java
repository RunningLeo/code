package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:22 2019-02-20
 * @Desc ：
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsinaStringIII557 {

	public static String reverseWords(String s) {

		if(s == null || s.length() == 0){
			return "";
		}

		String[] arrays = s.split(" ");
		StringBuilder sb = new StringBuilder();
		int n = arrays.length;
		for (int i = 0; i < n; i++) {
			String item = arrays[i];
			sb.append(reverse(item));
			if(i != n-1){
				sb.append(" ");
			}
		}

		return sb.toString();

	}

	public static String reverse(String s){

		int n = s.length();
		StringBuilder sb = new StringBuilder();

		for (int i = n-1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		String res = reverseWords(s);
		System.out.println("反转字符: "+res);
	}
}
