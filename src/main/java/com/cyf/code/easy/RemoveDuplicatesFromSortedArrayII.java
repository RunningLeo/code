package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 09:03 2019-02-16
 * @Desc ：
 * Follow up for ”Remove Duplicates”: What if duplicates are allowed at most twice?
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3]
 */
public class RemoveDuplicatesFromSortedArrayII {

	public static int removeDuplicates(int [] a){

		if(a == null || a.length == 0){
			return 0;
		}

		int n = a.length;
		int index = 0;
		int counter = 0;

		for (int i = 1; i < n; i++) {

			if(a[i] != a[i-1]){
				index++;
				counter = 0;
			}else {
				counter++;
				if(counter == 1){
					index++;
				}else {
					continue;
				}
			}
		}

		return index+1;

	}

	public static void main(String[] args) {
		int [] a = new int[]{1,1,1,2,2,3,3};
		int len = removeDuplicates(a);
		System.out.println("====len="+len);
	}
}
