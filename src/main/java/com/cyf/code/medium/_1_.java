package com.cyf.code.medium;

import java.util.Scanner;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:43 2020/3/8
 * @Desc ：
 * *c*m*b*n*t*
 * ******cmbnt
 */
public class _1_ {

	public static String transfer(String str) {


			if (str == null || str.length() == 0) {
				return str;
			}

			char[] chars = str.toCharArray();

			int len = chars.length;


			StringBuilder xingStr = new StringBuilder();
			StringBuilder charStr = new StringBuilder();

			for (int i = 0; i < len; i++) {

				if (chars[i] == '*') {
					xingStr.append(chars[i]);
				} else {
					charStr.append(chars[i]);
				}
			}

			return xingStr.append(charStr).toString();
		}


//		int endIndex = len -1;
//		int charEndIndex = len -1;
//
//		for (int i = endIndex ; i >= 0 ; i--) {
//
//			if(chars[i] == '*'){
//				while (chars[charEndIndex] == '*' && charEndIndex >= 0){
//					charEndIndex--;
//				}
//
//				if(charEndIndex < 0){
//					String res = "";
//					for (int j = 0; j <len ; j++) {
//						res = res + chars[j];
//					}
//					return res;
//				}
//			}
//		}



	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			String res = transfer(str);

			System.out.println(res);
		}

	}
}
