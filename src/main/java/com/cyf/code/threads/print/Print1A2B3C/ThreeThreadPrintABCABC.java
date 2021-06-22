package com.cyf.code.threads.print.Print1A2B3C;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:26 2019-12-25
 * @Desc ：三个线程轮流执行顺序打印ABC，依次是ABCABCABC.
 */
public class ThreeThreadPrintABCABC {


	public static void main(String[] args) {

		ReentrantLock LOCK = new ReentrantLock();
		Condition c1 = LOCK.newCondition();
		Condition c2 = LOCK.newCondition();
		Condition c3 = LOCK.newCondition();

		new Thread(() -> {
			LOCK.lock();
			try {
				for (int i = 0; i< 10; i++){
					System.out.println(Thread.currentThread().getName()+"======>A");
					c2.signal();
					c1.await();
				}
				c2.signal();
			}catch (InterruptedException e){

			}finally {
				LOCK.unlock();
			}
		}, "t1").start();



		new Thread(() -> {
			LOCK.lock();
			try {
				for (int i = 0; i< 10; i++){
					System.out.println(Thread.currentThread().getName()+"======>B");
					c3.signal();
					c2.await();
				}
				c3.signal();
			}catch (InterruptedException e){

			}finally {
				LOCK.unlock();
			}
		}, "t2").start();

		new Thread(() -> {
			LOCK.lock();
			try {
				for (int i = 0; i< 10; i++){
					System.out.println(Thread.currentThread().getName()+"======>C");
					c1.signal();
					c3.await();
				}
				c1.signal();

			}catch (InterruptedException e){

			}finally {
				LOCK.unlock();
			}
		}, "t3").start();


	}
}
