package com.cyf.code.hard;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:55 2019-02-16
 * @Desc ：There are two sorted arrays A and B of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log(m + n)).
 */
public class _4_寻找两个正序数组的中位数 {

	public static double findMedian(int[] a, int[] b) {
		int len1;
		int len2;
		if (a == null || a.length == 0) {

			len2 = b.length;
			if ((len2 & 1) == 1) {
				return b[len2>>1];
			} else {
				return (b[(len2 -1)>>1] + b[(len2+1)>>1]) / 2.0;
			}
		}

		if (b == null || b.length == 0) {
			len1 = a.length;
			if ((len1 & 1) == 1) {
				return a[len1>>1];
			} else {
				return (a[(len1-1)>>1] + a[(len1+1)>>1]) / 2.0;
			}
		}
		len1 = a.length;
		len2 = b.length;
		int[] c = new int[len1 + len2];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < len1 && j < len2) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		while (i < len1) {
			c[k++] = a[i++];
		}
		while (j < len2) {
			c[k++] = b[j++];
		}

		int n = len1 + len2;
		if ((n & 1) == 1 ) {
			//奇数个
			return c[n>>1];
		} else {

			return (c[(n-1)>>1] + c[(n+1)>>1])/2.0;
		}


	}

	public static void main(String[] args) {
		int[] a = new int[]{1, 3};
		int[] b = new int[]{2};

		double median = findMedian(a, b);
		System.out.println("==中位数是：" + median);
	}
}
