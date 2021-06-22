package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 08:08 2019-05-26
 * @Desc ：
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aaabb", k = 3
 * <p>
 * 输出:
 * 3
 * <p>
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 * <p>
 * 输入:
 * s = "ababbc", k = 2
 * <p>
 * 输出:
 * 5
 * <p>
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
public class longestSubStringK {

	public static int getLongSub(String s, int k) {

		if (s.length() < k) {
			return 0;
		} else if (k == 1) {
			return s.length();
		}

		return longestSubstring(s, 0, s.length() - 1, k);

	}

	public static int longestSubstring(String s, int left, int right, int k) {

		if (right - left + 1 < k) {
			return 0;
		}

		int[] counts = new int[26];

		for (int i = left; i <=right; i++) {
			counts[s.charAt(i) - 'a']++;
		}

		int maxLength = 0;

		int last = left;

		boolean isSplit = false;

		for (int i = left; i <=right ; i++) {

			if(isSplit(counts, s.charAt(i), k)){
				maxLength = Math.max(maxLength, longestSubstring(s,last , i-1, k));
				last = i+1;
				isSplit = true;
			}else if(isSplit && i == right) {
				maxLength = Math.max(maxLength, longestSubstring(s, last, right, k));
			}
		}

		if(isSplit){
			return maxLength;
		}else {
			return right - left + 1;
		}
	}

	public static boolean isSplit(int[] counts, char c, int k) {
		int i = c - 'a';
		return counts[i] < k && counts[i] > 0;
	}


	public static void main(String[] args) {
		String s = "dddaabccc";
		int k = 3;

		int res = getLongSub(s, k);

		System.out.println("=====max=" + res);
	}
}
