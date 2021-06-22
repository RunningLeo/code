package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:08 2020/3/7
 * @Desc ：
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _231_2的幂 {

	public static boolean isPowerOfTwo(int n) {

		if(n <= 0){
			return false;
		}
		if(n == 1){
			return true;
		}

		boolean flag = false;

		while (n != 0){

			if((n & 1) == 1){
				if(flag){
					return false;
				}
				flag = true;
			}

			n >>= 1;
		}

		return true;
	}

	public static void main(String[] args) {


		int n = -16;
		boolean flag = isPowerOfTwo(n);
		System.out.println("===flag="+flag);
	}
}
