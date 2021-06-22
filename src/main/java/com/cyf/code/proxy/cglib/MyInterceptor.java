package com.cyf.code.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:11 2019-08-19
 * @Desc ：
 */
public class MyInterceptor implements MethodInterceptor {

	public <T> T getInstance(T target){

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());

		//回调增强
		enhancer.setCallback(this);
		return (T)enhancer.create();

	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		System.out.println("======begin===");

		//调用父类方法
		Object result = proxy.invokeSuper(obj, args);

		System.out.println("======end=====");

		return result;
	}
}
