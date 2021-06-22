package com.cyf.code.zuo.chapter1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:44 2020/4/16
 * @Desc ： 生成窗口最大值数组
 * 给定一个数组和一个大小n,生成大小为n的窗口每次滑动时的最大值
 *
 */
public class GenMaxWindow {


	public static int [] getMaxWindow(int [] arr, int n){

		int len = arr.length;

		//双端队列处理滑动窗口
		Deque<Integer> deque = new ArrayDeque();

		int index = 0;

		int [] res = new int[len - n + 1];

		for (int i = 0; i < len; i++) {

			int cur = arr[i];

			while (!deque.isEmpty() && arr[deque.peekLast()] <= cur){
				deque.pollLast();
			}

			deque.addLast(i);

			if(deque.peekFirst() == i - n){
				//头节点已过期
				deque.pollFirst();
			}

			if(i >= n-1){
				res[index++] = arr[deque.peekFirst()];
			}

		}

		return res;
	}


	public static void main(String[] args) {

		int [] arr = new int[]{4,3,5,4,3,3,6,7};
		int n = 3;

		int [] res = getMaxWindow(arr, n);

		Arrays.stream(res).forEach(System.out::println);

	}
}
