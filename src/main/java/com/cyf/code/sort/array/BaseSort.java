package com.cyf.code.sort.array;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:52 2019-07-25
 * @Desc ：
 */
public abstract class BaseSort {

	abstract void sort(int [] array);

	protected void swap(int i, int j, int [] array){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
