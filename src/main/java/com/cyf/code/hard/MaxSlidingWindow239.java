package com.cyf.code.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:03 2019-02-13
 * @Desc ：滑动窗口
 */
public class MaxSlidingWindow239 {

	public static int [] maxSlidingWindow(int [] a, int k){

		if(a == null || k <= 0){
			return new int[0];
		}

		int n = a.length;
		//共有n-k+1次滑动
		int [] res = new int[n-k+1];
		//保存元素下标
		Deque<Integer> q = new ArrayDeque<Integer>();

		//res数组的下标指针
		int resIndex = 0;


		for (int i = 0; i < n ; i++) {

			/**
			 * 确保q中保存的下标长度小于等于窗口的长度，
			 * i-k+1为当前元素作为窗口右侧边界时，窗口左侧边界的元素下标，如果队列中的第一个元素的下标小于左侧边界，
			 * 则说明队列中保存的下标过多，需要保证队列中的下标个数<=k
			 */
			while (!q.isEmpty() && q.peekFirst() < i-k+1){
				q.poll();
			}

			/**
			 * 如果队列中最后一个下标对应的元素<a[i]，则循环移除最后一个下标，
			 * 直到保证队列的第一个下标对应的元素为当前窗口的最大值
			 */
			while (!q.isEmpty() && a[q.peekLast()] < a[i]){
				q.pollLast();
			}

			//队列中加入当前元素的下标
			q.offer(i);

			/**
			 * i<k-1时，窗口刚开始滑动时，元素没有填充满窗口，无法选出最大值
			 */
			if(i >= k-1){
				res[resIndex++] = a[q.peek()];
			}

		}

		return res;


	}

	public static void main(String[] args) {
		int[] a = {6, 3, 4, 2, 5, 9, 1};
		//窗口大小为3
		int k = 3;
		int [] max = maxSlidingWindow(a, k);
		System.out.println("滑动窗口的最大值：");
		Arrays.stream(max).forEach(System.out::println);

	}


	/**
	 * 队列的方法介绍
	 * add        增加一个元索             如果队列已满，则抛出一个IIIegaISlabEepeplian异常
	 * remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
	 * element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
	 * offer       添加一个元素并返回true       如果队列已满，则返回false
	 * poll         移除并返问队列头部的元素    如果队列为空，则返回null
	 * peek       返回队列头部的元素             如果队列为空，则返回null
	 * put         添加一个元素                      如果队列满，则阻塞
	 * take        移除并返回队列头部的元素  
	 */
}
