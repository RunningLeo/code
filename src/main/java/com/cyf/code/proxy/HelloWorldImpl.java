package com.cyf.code.proxy;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:13 2019-05-05
 * @Desc ：
 */
public class HelloWorldImpl implements HelloWorld {


	@Override
	public void print() {
		System.out.println("====代理===hello-world");
	}


}
