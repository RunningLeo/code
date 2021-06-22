package com.cyf.code.medium;

/**
 * @author ：caoyafei
 * @Date ：Created in 18:14 2019-05-25
 * @Desc ：
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchArrays {

	public static int search(int[] a, int target) {

		if (a == null) {
			return -1;
		}
		if (a.length == 1 && a[0] != target) {
			return -1;
		}


		int n = a.length;

		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (a[mid] == target) {
				return mid;
			} else if(a[mid] < target){

				if(a[mid] >= a[start]){
					start = mid +1;
				}else {
					if(a[end] < target){
						end = mid -1;
					}else {
						start = mid +1;
					}
				}

			}else {
				if(a[mid] >= a[start]){
					if(a[start] > target){
						start = mid + 1;
					}else {
						end = mid -1;
					}
				}else {
					end = mid -1;
				}

			}


		}

		return -1;

	}

	public static void main(String[] args) {
		int[] a = new int[]{3,1};
		int target = 1;

		int index = search(a, target);

		System.out.println("=====index=" + index);
	}
}
