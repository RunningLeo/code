package com.cyf.code.threads.print.Print1A2B3C;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:16 2019-12-24
 * @Desc ：启动两个线程，交替打印1A2B3C....
 */
public class Print1A2B {

	static Thread t1;
	static Thread t2;

	public static void main(String[] args) {

		 t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 1; i<= 26; i++){
					System.out.println(Thread.currentThread().getName()+"===>"+i);
					LockSupport.unpark(t2);
					LockSupport.park();

				}

			}
		}, "t1");

		 t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (char c = 'A'; c <= 'Z'; c++){
					LockSupport.park();
					System.out.println(Thread.currentThread().getName()+"===>"+c);
					LockSupport.unpark(t1);
				}
				LockSupport.unpark(Thread.currentThread());


			}
		}, "t2");

		t1.start();
		t2.start();

	}





}
