package com.cyf.code.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:43 2020-02-26
 * @Desc ：对hello接口动态代理
 */
public class HelloProxy {

	public static void main(String[] args) {



		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method);
				if (method.getName().equals("morning")) {
					System.out.println("Good morning, " + args[0]);
				}
				return null;
			}
		};
		Hello hello = (Hello) Proxy.newProxyInstance(
				Hello.class.getClassLoader(), // 传入ClassLoader
				new Class[] { Hello.class }, // 传入要实现的接口
				handler); // 传入处理调用方法的InvocationHandler
		hello.morning("Bob");
	}


	interface Hello {
		void morning(String name);
	}
}


