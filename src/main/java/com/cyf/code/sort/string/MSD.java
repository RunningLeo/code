package com.cyf.code.sort.string;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:23 2019-07-30
 * @Desc ：
 * 高位优先的字符串排序MSD
 * 高位优先的字符串排序MSD可以处理不等长的字符串，它是从左向右检查每个字符，统计字符串首字母的频率，并按其来进行归类、排序，然后对归类后的字符串：将所有首字母相同的归为一个子数组，递归地分别对这些子数组排序。精炼点说就是：
 *
 * 以首字母来排序，将数组切分成首字母相同的子数组
 * 忽略都相同的首字母，递归地排序子数组
 *
 * https://www.cnblogs.com/sun-haiyu/p/7877651.html
 */
public class MSD {
	// 基数
	private static int R = 256;
	// 切换为插入排序的阈值
	private static int M = 15;

	public static void sort(String[] a) {
		int N = a.length;
		String[] aux = new String[N];
		sort(a, aux, 0, a.length - 1, 0);
	}

	private static void sort(String[] a, String[] aux, int low, int high, int d) {
		// 对于小型数组，切换到插入排序
		if (high <= low + M) {
			insertSort(a, low, high, d);
			return;
		}
		// 在原来R+1的基础上多加1是因为要将字符串末尾存放到count[1]中， count[0]依然始终为0
		int[] count = new int[R + 2];
		// 统计频率
		for (int i = low; i <= high; i++) {
			count[charAt(a[i], d) + 2]++;
		}
		// 转换成开始索引
		for (int r = 0; r < R + 1; r++) {
			count[r+1] += count[r];
		}
		// 数据分类
		for (int i = low; i <= high; i++) {
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}
		// 写回原数组
		for (int i = low; i <= high ; i++) {
			a[i] = aux[i-low];
		}

		// 递归的以每个字符为键进行排序
		// 实际上每次递归处理的都是首字母相同的子数组，
		// [low + count[r], low + count[r+ 1] -1]是首字母都相同的子数组区间
		// d+1表示忽略都相同的首字母，从下一个字符开始统计频率 -> 计数排序
		for (int r = 0; r < R; r++) {
			sort(a,  aux, low + count[r], low + count[r+ 1] -1, d + 1);
		}
	}

	private static int charAt(String s, int d) {
		if (d < s.length()) {
			return s.charAt(d);
		} else {
			return -1;
		}
	}

	private static void insertSort(String[] a, int low, int high, int d) {
		for (int i = low + 1; i <= high; i++) {
			// 当前索引如果比它前一个元素要大，不用插入;否则需要插入
			if (less(a[i], a[i - 1], d)) {
				// 待插入的元素先保存
				String temp = a[i];
				// 元素右移
				int j;
				for (j = i; j > low && less(temp, a[j - 1], d); j--) {
					a[j] = a[j - 1];
				}
				// 插入
				a[j] = temp;
			}
		}
	}

	private static boolean less(String v, String w, int d) {
		return v.substring(d).compareTo(w.substring(d)) < 0;
	}

	public static void main(String[] args) {
		String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the",
				"shells", "she", "sells", "are", "surely", "seashells"};
		MSD.sort(a);
		System.out.println(Arrays.toString(a));
        /* Output:
        [are, by, sea, seashells, seashells, sells, sells, she, she, shells, shore, surely, the, the]
        */
	}
}
