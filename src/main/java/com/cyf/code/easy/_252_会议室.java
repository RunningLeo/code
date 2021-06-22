package com.cyf.code.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午6:38 2020/5/20
 * @Desc ：Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 *
 */
public class _252_会议室 {

	public static boolean attend(int [][] meetings){

		//首先根据每个会议的start排序
		mySort(meetings, 0);


		//然后从第二个元素开始遍历，如果后一个的开始时间在前一个的结束时间之前，则不能参加

		int len = meetings.length;

		for (int i = 1; i < len; i++) {

			if(meetings[i][0] < meetings[i-1][1]){
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {

		int [][] meetings = new int[3][];
		meetings[0] = new int[]{0,30};
		meetings[1] = new int[]{15,20};
		meetings[2] = new int[]{5,10};

		boolean flag = attend(meetings);

		System.out.println("===>"+flag);



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
