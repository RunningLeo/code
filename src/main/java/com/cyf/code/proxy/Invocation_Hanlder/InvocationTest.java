package com.cyf.code.proxy.Invocation_Hanlder;

import com.cyf.code.proxy.HelloWorld;
import com.cyf.code.proxy.HelloWorldImpl;

import java.lang.reflect.Proxy;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:23 2019-05-05
 * @Desc ：
 */
public class InvocationTest {

	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorldImpl();

		HelloWorldInvocationHanlder helloWorldInvocationHanlder = new HelloWorldInvocationHanlder(helloWorld);

		HelloWorld helloWorldProxy = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), helloWorldInvocationHanlder);

		helloWorldProxy.print();

	}
}
