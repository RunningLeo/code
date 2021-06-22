package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:00 2019-02-19
 * @Desc ：
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
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
 * <p>
 * 分析：用动态规划的思想分解问题，首先声明一个二维数组，d[i][j]。
 * 如果d[i][j] = 1,表示字符串下标从i~j的子串为回文串，且 d[i+1][j-1] = 1.
 */
public class LongestPalindromicSubstring5 {

	public static String longestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return "";
		}
		int n = s.length();

		if (n == 1) {
			return s;
		}

		int start = 0;
		int end = 0;

		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			if (i < n - 1) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					dp[i][i + 1] = 1;
					start = i;
					end = i+2;
				}
			}
		}

		for (int l = 3; l <= n; l++)//子串长度
		{
			for (int i = 0; i+l-1 < n; i++)//枚举子串的起始点
			{
				int j=l+i-1;//终点
				if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==1)
				{
					dp[i][j] = 1;
					start=i;
					end = i+l-1;
				}
			}
		}

		return s.substring(start, end+1);


	}

	public static void main(String[] args) {
		String s = "ac";
		String ss = longestPalindrome(s);
		System.out.println("===最长回文子串: " + ss);

	}
}
