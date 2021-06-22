package com.cyf.code.medium;

import java.util.ArrayDeque;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:35 2019-03-28
 * @Desc ：最大值-最小值 小于或等于某值的子数组的数量
 * 给定数组arr和整数 num，共返回有多少个数组满足下列情况： max(arr[i..j])-min(arr[i..j])<=num。
 * 其中max(arr[i..j]) 表示子数组arr[i..j] 中的最大值，min(arr[i..j]) 表示子数组arr[i..j] 中的最小值。
 * 如果数组的长度为N，要求时间复杂度是 O(N)。
 * 若某个数组满足条件，那么它所包含的子数组肯定都满足条件
 * 若某数组不满足条件，那么包含它的所有数组肯定不满足条件
 */
public class ArraySubNums {

	public static int getNum(int[] a, int num) {

		if (a == null || a.length == 0) {
			return 0;
		}

		int count = 0;

		ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
		ArrayDeque<Integer> minQueue = new ArrayDeque<>();

		int len = a.length;

		int head = 0;
		int tail = 0;

		while (head < len) {

			while (tail < len) {

				while (!maxQueue.isEmpty() && a[maxQueue.peekLast()] <= a[tail]) {
					maxQueue.pollLast();
				}
				maxQueue.addLast(tail);

				while (!minQueue.isEmpty() && a[minQueue.peekLast()] >= a[tail]) {
					minQueue.pollLast();
				}
				minQueue.addLast(tail);


				if (a[maxQueue.peekFirst()] - a[minQueue.peekFirst()] > num) {
					break;
				}

				tail++;

			}

			//以 head = i为头节点的遍历完毕，更换对列头节点，为后面作准备
			if (maxQueue.peekFirst() == head) {
				maxQueue.pollFirst();
			}

			if (minQueue.peekFirst() == head) {
				minQueue.pollFirst();
			}

			count += tail - head;

			head++;

		}

		return count;

	}

	public static void main(String[] args) {

		int[] a = new int[]{3, 5, 1};

		int num = 3;

		int count = getNum(a, num);

		System.out.println("=====count=" + count);

	}


}
