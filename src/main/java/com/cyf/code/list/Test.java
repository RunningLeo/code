package com.cyf.code.list;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 18:11 2020-01-09
 * @Desc ：
 */
public class Test {


	public void test1(){
		System.out.println(Thread.currentThread().getName()+"======1");
	}

	public void test2(){
		System.out.println(Thread.currentThread().getName()+"======2");
	}


	public static void main(String[] args) {

		Test tt = new Test();

		Lock lock1 = new ReentrantLock();

		Lock lock2 = new ReentrantLock();

		new Thread(() -> {
			lock1.lock();

			try {
				tt.test1();
				try {
					Thread.sleep(10000);
				}catch (InterruptedException e){

				}
				tt.test2();

			}finally {
				lock1.unlock();
			}
		}).start();


		new Thread(() -> {
			lock1.lock();

			try {
				tt.test1();
				tt.test2();


			}finally {
				lock1.unlock();
			}
		}).start();

	}
}
