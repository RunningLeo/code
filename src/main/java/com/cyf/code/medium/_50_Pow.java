package com.cyf.code.medium;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:08 2020/5/19
 * @Desc ：实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class _50_Pow {

	public static double myPow(double x, int n) {

		double res = myPow3(x, n);

		return n > 0 ? res : 1 / res;

	}


	/**
	 * 递归解法
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPow2(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}

		if ((n & 1) == 0) {
			//n是偶数
			double temp = myPow2(x, n / 2);
			return temp * temp;
		} else {
			//n是奇数
			double temp = myPow2(x, n / 2);
			return temp * temp * x;
		}
	}

	/**
	 * 非递归解法
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPow3(double x, int n) {

		if(n == 0){
			return 1;
		}

		if(n == 1){
			return x;
		}


		double res = 1;

		if(n < 0){

			if(n == Integer.MIN_VALUE){
				res = x;
				n++;
			}
			n = - n;
		}



		while (n > 1){

			if((n & 1) == 1){
				//n是奇数
				res *= x;
			}

			x *= x;

			n = n >>> 1;
		}

		return res * x;

	}




	public static void main(String[] args) {
		double x = 2;
		int n = -2;

		double res = myPow(x, n);

		System.out.println("===>res=" + res);
	}
}
