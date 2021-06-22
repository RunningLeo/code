package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 08:54 2019-02-16
 * @Desc ：
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesFromSortedArray {

	public static int  removeDuplicates(int [] a){

		if(a == null || a.length == 0){
			return 0;
		}

		int index = 0;
		int n = a.length;
		for (int i = 1; i < n; i++) {
			if(a[i] != a[i-1]){
				index++;
			}
		}
		return index+1;

	}

	public static void main(String[] args) {
		int []  a = new int[]{1,1,2,3,3,5};
		int len = removeDuplicates(a);
		System.out.println("====len="+ len);
	}

}
