package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:57 2018/9/18
 * @Desc ：
 */
public class MySqrt68 {
	public static int mySqrt(int x) {

		if (x == 0) {
			return 0;
		} else if (x == 1) {
			return 1;
		} else {
			int left = 0;
			int right = x;
			int mid = 0;
			while (left != right) {
				mid = (left + right) / 2;
				if (mid > x / mid) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			return left - 1;
		}

	}

	public static void main(String[] args) {
		int n = 7;
		int res = mySqrt(n);
		System.out.println("======res=" + res);
	}
}
