package com.cyf.code.threads.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:29 2019-08-30
 * @Desc ：
 */
public class LockABC {

	private static Lock lock = new ReentrantLock();

	//通过state的值来确定是哪个线程打印
	private static int state = 0;

	static class ThreadA extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
					while (state % 3 == 0) {
						System.out.println(Thread.currentThread().getName() + "=======A");
						state++;
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}

	static class ThreadB extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					while (state % 3 == 1) {
						System.out.println(Thread.currentThread().getName() + "=======B");
						state++;
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}


	static class ThreadC extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					lock.lock();
					while (state % 3 == 2) {
						System.out.println(Thread.currentThread().getName() + "=======C");
						state++;
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}

}
