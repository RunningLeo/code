package com.cyf.code.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 13:54 2019-05-26
 * @Desc ：
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class Partition {

	public static List<List<String>>  partition(String s){

		List<List<String>> result = new ArrayList<>();

		List<String> list = new ArrayList<>();

		if(s == null){
			return result;
		}
		getPartition(s, list, result);

		return result;

	}


	public static void   getPartition(String s, List<String> list, List<List<String>> result){

		int n = s.length();

		if(n == 0){
			List<String> temp = new ArrayList<>(list);
			result.add(temp);
			return;
		}

		for (int i = 1; i <= n ; i++) {

			String pre = s.substring(0, i);
			String post = s.substring(i);

			if(isHuiWen(pre)){
				list.add(pre);
				getPartition(post, list, result);
				list.remove(list.size() -1 );
			}

		}


	}

	public static boolean isHuiWen(String s){

		int start = 0;
		int end = s.length() -1;

		if(start > end){
			return false;
		}

		while (start <= end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}


	public static void main(String[] args) {
		String s = "bb";
		List<List<String>> result = partition(s);

		result.stream().forEach(System.out::println);
	}
}
