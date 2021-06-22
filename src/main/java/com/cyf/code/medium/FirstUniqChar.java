package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:31 2019-05-26
 * @Desc ：
 */
public class FirstUniqChar {

	public static int firstUniqChar(String s){

		if(s == null){
			return -1;
		}

		int n = s.length();

		int [] counts = new int[26];

		for (int i = 0; i <n ; i++) {
			counts[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i <n ; i++) {

			if(counts[s.charAt(i) - 'a'] == 1){
				return i;
			}

		}

		return -1;

	}

	public static void main(String[] args) {
		String s = "loveleetcode";

		int index = firstUniqChar(s);

		System.out.println("=====index="+index);
	}
}
