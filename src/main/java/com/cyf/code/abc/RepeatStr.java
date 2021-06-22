package com.cyf.code.abc;

import java.util.Scanner;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:31 2019-05-20
 * @Desc ：
 */
public class RepeatStr {

	public static String fixStr(String res){

		if(res == null || res.length() == 0){
			return "";
		}

		StringBuilder temp = new StringBuilder();

		char [] chars = res.toCharArray();

		int len = chars.length;

		temp.append(chars[0]);

		//处理3个连续重复的
		for (int i = 1; i < len-1; i++) {

			if(chars[i-1] == chars[i] && chars[i] == chars[i+1]){
				continue;
			}
			temp.append(chars[i]);

		}
		temp.append(chars[len - 1]);

		//处理AABB
		char [] chars1 = temp.toString().toCharArray();

		StringBuilder temp2 = new StringBuilder();

		temp2.append(chars1[0]);
		temp2.append(chars1[1]);
		temp2.append(chars1[2]);

		for (int i = 3; i < chars1.length ; i++) {

			if(chars1[i] == chars1[i-1] && chars1[i-2] == chars1[i-3]){

				String rr = temp2.toString();
				int rlen = rr.length();
				if(rr.charAt(rlen - 1) == chars1[i] && rr.charAt(rlen -2) == rr.charAt(rlen -3)){
					continue;
				}
			}
			temp2.append(chars1[i]);
		}

		return temp2.toString();




	}

	public static void main(String[] args) {

		System.out.println("====请输入字符串：");
		Scanner sc  = new Scanner(System.in);

		String res = sc.nextLine();

		String result = fixStr(res);

		System.out.println("=====fix="+result);

	}
}
