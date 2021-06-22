package com.cyf.code.medium;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午7:12 2020/5/20
 * @Desc ：
 *给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[ s1 , e1 ] ，[ s2 , e2 ]，…] (si < ei) ，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排
 *
 * 输入：[[0, 30],[5, 10],[15, 20]]
 * 输入：2

 */
public class _253_最少会议室 {

	public static int minMeetingRooms(int[][] arr) {

		//首先根据每个会议的start排序
		mySort(arr, 0);

		int len = arr.length;

		int count = 1;

		int max = arr[0][1];

		for (int i = 1; i < len; i++) {

			int [] cur = arr[i];

			if(cur[0] < max){

				if(max > cur[1]){
					max = cur[1];
				}
				count++;
			}else {
				max = cur[1];
			}
		}

		return count;
	}

	public static void main(String[] args) {

		int [][] meetings = new int[3][];
		meetings[0] = new int[]{0,30};
		meetings[1] = new int[]{15,20};
		meetings[2] = new int[]{5,10};

		Integer count = minMeetingRooms(meetings);

		System.out.println("====>"+count);

	}


	/**
	 * 自定义排序
	 * @param arr
	 * @param col 根据第几列下标进行排序
	 * @return
	 */
	public static int [][] mySort(int [][] arr, int col){

		Arrays.sort(arr, (o1, o2) -> {
			if(o1[col] < o2[col]){
				return -1;
			}else if(o1[col] > o2[col]){
				return 1;
			}else {
				return 0;
			}
		});

		return arr;

	}
}
