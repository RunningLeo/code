package com.cyf.code.other;

import java.util.Objects;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午2:40 2018/11/13
 * @Desc ：
 */
public class Singleton {

	private Singleton(){
		System.out.println("=====create singleton");
	}

	private static Singleton instance = null;

	private static Singleton getInstance(){
		System.out.println("===111");
		if(Objects.isNull(instance)){
			instance = new Singleton();
		}
		return instance;
	}

	public static void test(){
		System.out.println("====test");
	}


	public static void main(String[] args) {
		Singleton.test();
	}
}
