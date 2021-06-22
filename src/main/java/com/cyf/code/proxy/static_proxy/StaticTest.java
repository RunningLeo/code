package com.cyf.code.proxy.static_proxy;

import com.cyf.code.proxy.HelloWorld;
import com.cyf.code.proxy.HelloWorldImpl;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:18 2019-05-05
 * @Desc ：
 */
public class StaticTest {

	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldProxyStatic(new HelloWorldImpl());
		helloWorld.print();
	}
}
