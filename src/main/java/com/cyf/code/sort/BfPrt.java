package com.cyf.code.sort;

import com.google.common.base.Joiner;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:25 2020/4/23
 * @Desc ：bfprt算法  https://segmentfault.com/a/1190000008322873
 * 在一个无序的数组里找到第K小的数，
 *
 * 要求：数组长度为N, 复杂度 O(N)
 *
 * 三：时间复杂度分析
 * BFPRT 算法在最坏情况下的时间复杂度是 ，下面予以证明。令  为所求的时间复杂度，则有：
 *
 *
 * 接下来我们再来探讨下 BFPRT 算法为何选 5 作为分组主元，而不是 2, 3, 7, 9 呢？
 *
 * 首先排除偶数，对于偶数我们很难取舍其中位数，而奇数很容易。再者对于 3 而言，会有
 *
 *
 * ，它本身还是操作了 n 个元素，与以 5 为主元的
 *
 *  相比，其复杂度并没有减少。对于 7，9，... 而言，上式中的 10c，其整体都会增加，所以与 5 相比，5 更适合。
 */
public class BfPrt {


	public static int BFPRT(int [] array, int left, int right, int k){

		// 得到中位数的中位数下标（即主元下标）
		int pivot_index = GetPivotIndex(array, left, right);

		// 进行划分，返回划分边界
		int partition_index = Partition(array, left, right, pivot_index);
		int num = partition_index - left + 1;

		if (num == k)
			return partition_index;
		else if (num > k)
			return BFPRT(array, left, partition_index - 1, k);
		else
			return BFPRT(array, partition_index + 1, right, k - num);
	}


	/**
	 *  * 数组 array[left, right] 每五个元素作为一组，并计算每组的中位数，
	 *  * 最后返回这些中位数的中位数下标（即主元下标）。
	 *  *
	 *  * @attention 末尾返回语句最后一个参数多加一个 1 的作用其实就是向上取整的意思，
	 *  * 这样可以始终保持 k 大于 0。
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int GetPivotIndex(int array[], int left, int right)
	{
		if (right - left < 5)
			return InsertSort(array, left, right);

		int sub_right = left - 1;

		// 每五个作为一组，求出中位数，并把这些中位数全部依次移动到数组左边
		for (int i = left; i + 4 <= right; i += 5)
		{
			int index = InsertSort(array, i, i + 4);
			swap(array, ++sub_right, index);
		}

		// 利用 BFPRT 得到这些中位数的中位数下标（即主元下标）
		return BFPRT(array, left, sub_right, ((sub_right - left + 1) >> 1) + 1);
	}

	/**
	 * 利用主元下标 pivot_index 进行对数组 array[left, right] 划分，并返回
	 * 划分后的分界线下标。
	 */
	public static int Partition(int array[], int left, int right, int pivot_index)
	{
		swap(array, pivot_index, right); // 把主元放置于末尾

		int partition_index = left; // 跟踪划分的分界线
		for (int i = left; i < right; i++)
		{
			if (array[i] < array[right])
			{
				swap(array, partition_index++, i); // 比主元小的都放在左侧
			}
		}

		swap(array, partition_index, right); // 最后把主元换回来

		return partition_index;
	}


	/**
	 * 对数组 array[left, right] 进行插入排序，并返回 [left, right]
	 * 的中位数的下标。
	 */
	public static int InsertSort(int array[], int left, int right)
	{
		int temp;
		int j;

		for (int i = left + 1; i <= right; i++)
		{
			temp = array[i];
			j = i - 1;

			while (j >= left && array[j] > temp)
			{
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = temp;
		}

		return ((right - left) >> 1) + left;
	}


	public static void swap(int [] array, int a, int b){

		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}


	public static void main(String[] args) {

		// 1 <= k <= array.size
		int k = 5;

		int [] array = {11,9,10,1,13,8,15,0,16,2};

		Integer [] sort = {11,9,10,1,13,8,15,0,16,2};

		Arrays.sort(sort);

		System.out.println("原数组排序后："+ Joiner.on(",").join(sort));


		//第K小数字的下标
		int index = BFPRT(array, 0, array.length - 1, k);

		System.out.println("===第"+k+"小的数字："+ array[index]);

	}
}
