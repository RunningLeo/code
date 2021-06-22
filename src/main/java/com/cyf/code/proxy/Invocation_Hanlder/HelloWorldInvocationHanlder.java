package com.cyf.code.proxy.Invocation_Hanlder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:21 2019-05-05
 * @Desc ：
 */
public class HelloWorldInvocationHanlder implements InvocationHandler {

	private final Object obj;

	public HelloWorldInvocationHanlder(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		//反射调用
		Object result = method.invoke(obj, args);
		after();
		return result;
	}

	private void before(){
		System.out.println("=====Invocation===before");
	}

	private void after(){
		System.out.println("=====Invocation===after");
	}
}
