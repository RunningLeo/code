package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午8:34 2020/3/26
 * @Desc ：
 */
public class _3_无重复字符的最长子串 {

	public static int lengthOfLongestSubstring(String s) {

		if(s == null || s.length() == 0){
			return 0;
		}

		int len = s.length();

		if(len == 1){
			return 1;
		}

		int [] chars = new int[128];

		int max = 0;

		for (int i = 0; i < 128; i++) {
			chars[i] = -1;
		}


		int start = 0;
		int count = 0;
		for (int i = 0; i < len; i++) {

			int index = s.charAt(i) - ' ';

			if(chars[index] == -1){
				chars[index] = i;
				count++;

			}else {

				max = Math.max(max, count);

				if(start < chars[index]){
					start = chars[index];
				}

				count = i - start;

				chars[index] = i;
			}
		}

		return Math.max(max, count);

	}

	public static int lengthOfLongestSubstring2(String s) {
		int[] index = new int[128];
		int res = 0;
		int start = 0;
		int len = s.length();
		if(len == 1){
			return len;
		}
		for (int i = 0; i < len; i++) {
			char cur = s.charAt(i);

			start = Math.max(index[cur], start);

			res = Math.max(res, i - start + 1);

			index[cur] = i+1;
		}
		return res;
	}


	public static void main(String[] args) {
		String s = "au";
		int max = lengthOfLongestSubstring2(s);

		System.out.println("===max="+max);

	}
}

/**
 *
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
