package com.cyf.code.other;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:14 2019-02-28
 * @Desc ：1亿个数取最大的前100个数
 */
public class MyTop100 {
	static final int TOTAL = 100000000;//1亿个数
	static final int MAX = Integer.MAX_VALUE;//随机数最大值
	static final int SIZE = 100;//前100个最大数
	static final int[] TOPS = new int[SIZE];//存放最大值的数组

	public static void main(String[] args) {
		long start = System.nanoTime();//开始
		find(TOTAL, SIZE);//获取最大数
		System.out.println(Arrays.toString(TOPS));//打印
		long end = System.nanoTime();//结束
		System.out.println("time = " + (end - start) / 1e9 + " seconds");//输出时间
	}

	static void find(int total,int size){
		int num;
		Random ran = new Random();
		//前100个数直接存入数组
		for(int i = 0;i < size;++i){
			num = ran.nextInt(MAX);
			TOPS[i] = num;
		}
		setMin(TOPS);
		for(int i = size;i < total;++i){
			//如果当前数比arr[0]大，将arr[0]替换为num,再获取最小值放入arr[0]
			num = ran.nextInt(MAX);
			if(num > TOPS[0]){
				TOPS[0] = num;
				setMin(TOPS);
			}
		}

	}

	//获取当前最小值，放入arr[0]
	static void setMin(int[] arr){
		int min = arr[0];
		int index = 0;
		for(int i = 1;i < arr.length;i++){
			if(arr[i] < min){
				min = arr[i];
				index = i;
			}
		}
		int temp = arr[0];
		arr[0] = arr[index];
		arr[index] = temp;
	}
}
