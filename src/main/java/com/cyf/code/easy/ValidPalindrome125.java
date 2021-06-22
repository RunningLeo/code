package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:40 2019-02-19
 * @Desc ：
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * ASCII对照表
 * A-Z  65-90
 * a-z  97-122
 * 0-9  48-57
 */
public class ValidPalindrome125 {

	public static boolean isPalindrome(String s) {

		if(s == null || s.length() == 0){
			return true;
		}

		int n = s.length();
		int i = 0;
		int j = n - 1;
		while (i <= j) {
			int left = s.charAt(i);
			int right = s.charAt(j);

			if(!isRange(left)){
				i++;
				continue;
			}
			if(!isRange(right)){
				j--;
				continue;
			}

			if(left != right){
				//判断是否是数字
				if((left >= 48 && left <= 57) || (right >= 48 && right <= 57)){
					return false;
				}
				if(Math.abs(left - right) != 32){
					return false;
				}
			}
			i++;
			j--;
		}
		return true;

	}

	public static boolean isRange(int num) {
		if ((num > 57 && num < 'A') || (num > 'Z' && num < 'a') || num > 'z' || num < 48){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "0P";
		boolean flag = isPalindrome(s);
		System.out.println("是否是回文串：" + flag);
	}
}
