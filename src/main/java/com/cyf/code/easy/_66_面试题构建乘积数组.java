package com.cyf.code.easy;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午9:10 2020/5/19
 * @Desc ：给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _66_面试题构建乘积数组 {

	public static int[] constructArr(int[] a) {
		if (a.length == 0) {
			return a;
		}

		int len = a.length;

		int[] b = new int[len];

		int temp = a[0];
		b[0] = 1;

		//首先进行正向遍历, b[i] 存储 从 a[0]....a[i-1]的乘积
		for (int i = 1; i < len; i++) {

			b[i] = temp;

			temp *= a[i];

		}

		//然后进行反向遍历，求出temp = a[len-1].....a[i+1]的乘积，让b[i] *= temp
		//此时，b[i] = a[0]....a[i-1]的乘积 * a[i+1]....a[len-1]的乘积
		int temp2 = 1;
		for (int i = len - 1; i >=0; i--) {

			b[i] *= temp2;

			temp2 *= a[i];
		}

		return b;


	}

	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3, 4, 5};

		int[] b = constructArr(a);

		Arrays.stream(b).forEach(System.out::println);
	}
}
