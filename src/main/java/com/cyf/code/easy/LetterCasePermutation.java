package com.cyf.code.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:33 2019-05-26
 * @Desc ：
 */
public class LetterCasePermutation {

	static List<String> res = new ArrayList<>();

	static int dis = 'A' - 'a';


	public static List<String> letterCasePermutation(String s) {


		if (s.length() == 0) {
			return res;
		}

		char[] chars = s.toCharArray();

		helper(chars, 0);

		return res;


	}


	public static void helper(char[] cs, int idx) {

		res.add(String.valueOf(cs));

		for (int i = idx; i < cs.length; i++) {
			if (cs[i] >= '0' && cs[i] <= '9') {
				continue;
			} else if (cs[i] >= 'a' && cs[i] <= 'z') {
				cs[i] = (char) (cs[i] + dis);
				helper(cs, i + 1);
				cs[i] = (char) (cs[i] - dis);
			} else {
				cs[i] = (char) (cs[i] - dis);
				helper(cs, i + 1);
				cs[i] = (char) (cs[i] + dis);
			}
		}
	}

	public static void main(String[] args) {


		String s = "a1b2";

		List<String> res = letterCasePermutation(s);

		res.stream().forEach(System.out::println);
	}
}
