package com.cyf.code.proxy.cglib;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:10 2019-08-19
 * @Desc ：
 */
public final class Dog {

	//被final 修饰的方法不能被增强
	public final void eat(){
		System.out.println("====dog is eating");
	}

	public void sleep(){
		System.out.println("=====dog is sleep");
	}
}
