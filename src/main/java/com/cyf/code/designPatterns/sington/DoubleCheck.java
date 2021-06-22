package com.cyf.code.designPatterns.sington;

import lombok.Synchronized;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:57 2019-08-12
 * @Desc ：双重校验锁
 */
public class DoubleCheck {

	private DoubleCheck(){};

	public static volatile DoubleCheck INSTANCE;

	public static DoubleCheck getInstance(){
		if(INSTANCE == null){
			synchronized (DoubleCheck.class){
				if(INSTANCE == null){
					INSTANCE = new DoubleCheck();
					return INSTANCE;
				}
			}
		}
		return INSTANCE;
	}


	public static void main(String[] args) {
		DoubleCheck d1 = DoubleCheck.getInstance();
		DoubleCheck d2 = DoubleCheck.getInstance();

		System.out.println("======d1 hashcode="+d1.hashCode());
		System.out.println("======d2 hashcode="+d2.hashCode());

		System.out.println("====d1==d2==?"+(d1==d2));
	}
}
