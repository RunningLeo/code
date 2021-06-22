package com.cyf.code.leet.one_day_one_question;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:09 2020-03-03
 * @Desc ：
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1001_合并排序的数组 {


	public static void merge(int[] A, int m, int[] B, int n) {

		int[] tempArray = new int[A.length];

		int k = 0;

		int i = 0;

		int j = 0;

		while (i < m && j < n) {

			if (A[i] <= B[j]) {
				tempArray[k++] = A[i++];
			} else {
				tempArray[k++] = B[j++];
			}
		}


		while (i < m) {
			tempArray[k++] = A[i++];
		}

		while (j < n) {
			tempArray[k++] = B[j++];
		}

		for (int l = 0; l < m+n; l++) {
			A[l] = tempArray[l];
		}

	}

	public static void main(String[] args) {
		int [] A = new int[]{1,2,3,0,0,0};

		int [] B = new int[]{2,5,6};

		merge(A, 3, B, 3);


		Arrays.stream(A).forEach(System.out::println);
	}
}
