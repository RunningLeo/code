package com.cyf.code.zuo.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:11 2020/4/17
 * @Desc ：最大值减去最小值 小于或者等于 num的子数组的数量,
 * <p>
 * 给定一个数组和 数字num, 找到所有子数组中，最大值 减去 最小值 <= num 的子数组的数量
 * 要求时间复杂度O(N)
 *
 * 滑动窗口用双端队列
 */
public class GetSubArrayCount {

	public static int getSubCount(int[] array, int num) {

		int i = 0;
		int j = 0;
		int res = 0;

		int len = array.length;

		Deque<Integer> maxQueue = new ArrayDeque();

		Deque<Integer> minQueue = new ArrayDeque();



		while (i < len) {

			while (j < len){

				if(minQueue.isEmpty() || j != minQueue.peekLast()){

					while(!minQueue.isEmpty() && array[minQueue.peekLast()] >= array[j]){
						minQueue.pollLast();
					}

					minQueue.addLast(j);


					while(!maxQueue.isEmpty() && array[maxQueue.peekLast()] <= array[j]){
						maxQueue.pollLast();
					}
					maxQueue.addLast(j);

				}

				if(array[maxQueue.peekFirst()] - array[minQueue.peekFirst()] > num){
					break;
				}
				j++;
			}

			res += j - i;

			if (maxQueue.peekFirst() == i) {
				maxQueue.pollFirst();
			}

			if(minQueue.peekFirst() == i){
				minQueue.pollFirst();
			}
			i++;
		}

		return res;
	}


	public static void main(String[] args) {
		int[] array = new int[]{3, 6, 1, 8, 10, 2, 7};

		int num = 3;

		int res = getSubCount(array, num);

		System.out.println("===res="+res);
	}
}
