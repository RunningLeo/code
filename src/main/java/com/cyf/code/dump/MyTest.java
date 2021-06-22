package com.cyf.code.dump;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:29 2019-09-18
 * @Desc ：
 */
public class MyTest {

	Object o1 = new Object();
	Object o2 = new Object();

	public void fun1(){
		synchronized (o1){
			fun2();
		}

	}

	public void fun2(){
		synchronized (o2){
			while (true){
				System.out.println("=====");
			}

		}
	}


	public static void main(String[] args) {
		MyTest myTest = new MyTest();
		myTest.fun1();
	}
}
