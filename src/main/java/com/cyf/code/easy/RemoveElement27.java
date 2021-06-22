package com.cyf.code.easy;

/**
 * @author ：caoyafei
 * @Date ：Created in 18:01 2019-02-16
 * @Desc ：Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
 */
public class RemoveElement27 {

	public static int removeElement(int[] a, int target) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int n = a.length;
		int index = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] != target) {
				a[index++] = a[i];
			}
		}
		return index;

	}

	public static void main(String[] args) {
		int[] a = new int[]{3, 2, 2, 3};
		int target = 3;
		int len = removeElement(a, target);
		System.out.println("===len=" + len);
	}


}
