package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:39 2018/9/17
 * @Desc ：
 */
public class CountandSay38 {
	public static String countAndSay(int n) {

		if(n == 1){
			return "1";
		}else {
			StringBuilder sb = new StringBuilder("");
			String outPut = countAndSay(n-1);
			int len = outPut.length();
			int index = 0;
			while (index < len){
				char current = outPut.charAt(index);
				int count = 0;
				while (index < len && outPut.charAt(index) == current){
					index++;
					count++;
				}
				sb.append((char) ('0'+count)).append(current);
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		int n = 30;
		System.out.println("======res="+countAndSay(n));
	}

}
