package com.cyf.code.sort.array;

import java.util.Arrays;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:10 2019-02-11
 * @Desc ：
 */
public class BubbleSort extends BaseSort {



	@Override
	public void sort(int [] a){

		for (int i = 0; i < a.length -1 ; i++) {

			for (int j = 0; j < a.length -1 - i ; j++) {

				if(a[j] > a[j+1]){
					swap(j, j+1, a);
				}
			}

		}
	}

	/**
	 * 冒泡排序优化，设置
	 * 1.有序标示提前结束
	 * 2.有序边界，减少比对的次数
	 * @param a
	 */
	public void sort2(int [] a){

		int lastChangeIndex = 0;
		int sortBorder = a.length - 1;

		//排序的趟数
		for (int i = 0; i < a.length - 1 ; i++) {

			//是否有序
			boolean isSort = true;

			for (int j = 0; j < sortBorder ; j++) {

				if(a[j] > a[j+1]){
					swap(j, j+1, a);
					isSort = false;
					lastChangeIndex = j;
				}
			}

			//更新有序边界
			sortBorder = lastChangeIndex;

			//如果有序了，就直接结束排序
			if(isSort){
				break;
			}
		}

	}





	public static void main(String[] args) {
		int [] a = {6,3,8,2,9,1};
		System.out.println("排序前的数组：");
		Arrays.stream(a).forEach(System.out::println);

		new BubbleSort().sort2(a);

		System.out.println("排序后的数组：");
		Arrays.stream(a).forEach(System.out::println);

	}
}
