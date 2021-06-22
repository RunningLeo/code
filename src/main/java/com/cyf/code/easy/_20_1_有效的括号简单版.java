package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:26 2020/3/9
 * @Desc ：给定一个只包括 '('，')'的字符串，判断字符串是否有效。注：空字符串属于有效字符串
 * 示例 1:
 * 输入: "(())"
 * 输出: true
 *
 *  实例 2：
 *  输入: "())("
 * 输出: false
 *
 * 要求：空间复杂度 O(1)
 */
public class _20_1_有效的括号简单版 {

	public  static boolean isValid(String s){

		int count = 0;

		int len = s.length();

		if(len == 0){
			return true;
		}

		char [] chars = s.toCharArray();


		for (int i = 0; i < len ; i++) {

			if (chars[i] == ' ') {
				continue;
			}else if(chars[i] == '('){
				count++;
			}else {

				if(count == 0){
					return false;
				}
			    count--;
			}
		}

		return count == 0;

	}

	public static void main(String[] args) {
		String str = "(())";

		boolean flag = isValid(str);

		System.out.println("=====flag="+flag);
	}
}
