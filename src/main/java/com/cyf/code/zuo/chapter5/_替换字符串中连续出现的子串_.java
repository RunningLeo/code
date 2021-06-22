package com.cyf.code.zuo.chapter5;

import java.util.Collections;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:02 2020/4/28
 * @Desc ：替换字符串中连续出现的子串
 * 给定单个字符串str、from和to，已知from字符串中⚠️无重复字符），把str中所有from的子串全部替换成to字符串，
 * 对连续出现from的部分要求只替换成一个to字符串，返回最终结果字符串。
 * <p>
 * 举例：
 * <p>
 * str="123abc"，from="abc"，to="4567"，返回"1234567"；
 * <p>
 * str="123"，from="abc"，to="4567"，返回"123"；
 * <p>
 * str="123abcabc"，from="abc"，to="X"，返回"123X"；
 */
public class _替换字符串中连续出现的子串_ {

	public static String replace(String str, String from, String to) {

		char[] arrays = str.toCharArray();

		char[] chaf = from.toCharArray();

		int len = arrays.length;

		if (len < chaf.length) {
			return str;
		}

		int matcher = 0;

		for (int i = 0; i < len; i++) {

			if (arrays[i] == from.charAt(matcher++)) {
                 //⚠️ 因为from是无重复字符串组成，所以判断str是否包含时，不用KMP算法也可
				if (matcher == chaf.length) {
					//clear下标范围是 [i-chaf.length + 1, i]
					clear(arrays, i, matcher);
					matcher = 0;
				}
			} else {
				matcher = 0;
			}
		}

		String res = "";
		String cur = "";
		for (int i = 0; i < len; i++) {

			if (arrays[i] != 0) {
				cur += String.valueOf(arrays[i]);
			} else if (i == 0 || arrays[i - 1] != 0) {
				res = res + cur + to;
				cur = "";
			}
		}

		if (!cur.equals("")) {
			res += cur;
		}


		return res;
	}


	public static void clear(char[] arrays, int end, int len) {
		while (len-- != 0) {
			arrays[end--] = 0;
		}
	}

	public static void main(String[] args) {

		String str = "bbbfb";
		String from = "bbfb";
		String to = "X";

		String res = replace(str, from, to);

		System.out.println("====>" + res);

	}
}
