package com.cyf.code.threads.print.Print1A2B3C;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 21:18 2019-12-24
 * @Desc ：
 */
public class Print1A2BCondition {


	public static void main(String[] args) {


		ReentrantLock lock = new ReentrantLock();
		Condition c1 = lock.newCondition();
		Condition c2 = lock.newCondition();

		new Thread(() -> {

			lock.lock();
			try {
				for (int i = 1; i<= 26; i++){
					System.out.print(i);
					c2.signal();
					c1.await();
				}

				c2.signal();

			}catch (InterruptedException e){

			}finally {
				lock.unlock();
			}


		}, "t1").start();


		new Thread(() -> {

			lock.lock();

			try {
				for (char c = 'A'; c<='Z'; c++){
					System.out.print(c);
					c1.signal();
					c2.await();
				}

				c1.signal();

			}catch (InterruptedException e){

			}finally {
				lock.unlock();
			}

		}, "t1").start();
	}
}
