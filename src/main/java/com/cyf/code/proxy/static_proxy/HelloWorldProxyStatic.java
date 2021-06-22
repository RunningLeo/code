package com.cyf.code.proxy.static_proxy;


import com.cyf.code.proxy.HelloWorld;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:16 2019-05-05
 * @Desc ：
 */
public class HelloWorldProxyStatic implements HelloWorld {

	private  final HelloWorld helloWorld;

	public HelloWorldProxyStatic(HelloWorld helloWorld){
		this.helloWorld = helloWorld;
	}

	@Override
	public void print() {

		before();
		helloWorld.print();
		after();
	}


	private void before(){
		System.out.println("=====static===before");
	}

	private void after(){
		System.out.println("=====static===after");
	}
}
