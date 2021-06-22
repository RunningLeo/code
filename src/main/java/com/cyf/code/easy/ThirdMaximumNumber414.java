package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:26 2019-02-19
 * @Desc ：
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class ThirdMaximumNumber414 {

	public static int thirdMax(int[] a) {

		if (a == null || a.length == 0) {
			return 0;
		}

		int n = a.length;

		if (n == 1) {
			return a[0];
		}
		if (n == 2) {
			return Math.max(a[0], a[1]);
		}

		long max1 = Long.MIN_VALUE;
		long max2 = Long.MIN_VALUE;
		long max3 = Long.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (a[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = a[i];
			} else if (a[i] == max1) {
				continue;
			} else {
				if (a[i] > max2) {
					max3 = max2;
					max2 = a[i];
				} else if (a[i] == max2) {
					continue;
				} else {
					if (a[i] > max3) {
						max3 = a[i];
					}
				}
			}

		}

		return (max3 != Long.MIN_VALUE) ? (int) max3 : (int)max1;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,-2147483648};
		int third = thirdMax(a);
		System.out.println("第三大的数字: " + third);
	}
}
