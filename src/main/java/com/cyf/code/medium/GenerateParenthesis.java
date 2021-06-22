package com.cyf.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:11 2019-05-25
 * @Desc ：
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {


	public static void generate(String sub, List<String> result, int left, int right){

		if(left == 0 && right == 0){
			result.add(sub);
		}

		if(left > 0){
			generate(sub+"(", result, left-1, right);
		}

		if(right > left){
			generate(sub+")", result, left, right-1);
		}



	}


	public static void main(String[] args) {
		int n = 2;
		List<String> result = new ArrayList<>();

		generate("", result, n, n);

		result.stream().forEach(System.out::println);
	}
}
