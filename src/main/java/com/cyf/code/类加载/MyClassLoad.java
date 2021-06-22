package com.cyf.code.类加载;

import com.cyf.code.medium._120_三角形最小路径和;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:24 2020/5/28
 * @Desc ：
 */
public class MyClassLoad {

	public static void main(String[] args) {

		//String 是Bootstrap加载的，java环境获取不到
		System.out.println("===>"+String.class.getClassLoader());

		System.out.println("===>"+ _120_三角形最小路径和.class.getClassLoader());
	}
}
