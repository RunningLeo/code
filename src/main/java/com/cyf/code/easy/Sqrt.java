package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 13:36 2019-10-10
 * @Desc ：
 */
public class Sqrt {

	public static int sqrt(int x){

		if(x <= 1){
			return x;
		}

		int right = x / 2;
		int left = 1;

		while (left < right){
			int mid = (left + right) / 2;
			long temp = mid * mid;

			if(temp > x){
				right = mid - 1;
			}else if(temp < x){
				left = mid;
			}else {
				return mid;
			}
		}

		return left;
	}


	public static void main(String[] args) {
		int x = 8;
		int res = sqrt(x);
		System.out.println("====res="+res);
	}
}
