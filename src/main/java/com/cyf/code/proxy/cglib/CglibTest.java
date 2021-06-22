package com.cyf.code.proxy.cglib;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:15 2019-08-19
 * @Desc ：
 */
public class CglibTest {

	public static void main(String[] args) {

		MyInterceptor myInterceptor = new MyInterceptor();

		Dog dogProxy = (Dog) myInterceptor.getInstance(new Dog());

		dogProxy.eat();

		System.out.println("********************");

		dogProxy.sleep();

	}
}
