package com.cyf.code.hard;

import java.util.Stack;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:37 2020/3/9
 * @Desc ：
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _32_最长有效括号长度 {

	public static int longestValidParentheses(String s) {

		//dp[i] 长度为i的字符串的最长有效长度
		int len = s.length();
		if (len == 0 || len == 1) {
			return 0;
		}

		int[] dp = new int[len];
		dp[0] = 0;

		char[] chars = s.toCharArray();


		for (int i = 1; i < len; i++) {

			if(chars[i] == ')'){

				int pre = i - dp[i-1] - 1;

				if(pre >= 0 && chars[pre] == '('){
					dp[i] = dp[i-1] + 2;

					if(pre > 0){
						dp[i] += dp[pre - 1];
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			if(dp[i] > max){
				max = dp[i];
			}
		}

		return max;
}


	/**
	 * 用栈解决
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses2(String s) {

		Stack<Integer> stack = new Stack<>();

		int len = s.length();

		char [] chars = s.toCharArray();

		int max = 0;

		stack.push(-1);

		for (int i = 0; i < len; i++) {

			if(chars[i] == ')'){
				//出栈
				stack.pop();

				if(!stack.isEmpty()){
					max = Math.max(i - stack.peek(), max);
				}else {
					stack.push(i);
				}
				continue;
			}

			stack.push(i);
		}

		return max;

	}

	public static void main(String[] args) {
		String str = ")()())";

		int len = longestValidParentheses2(str);

		System.out.println("=====len=" + len);
	}
}
