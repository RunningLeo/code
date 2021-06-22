package com.cyf.code.threads.reentrant;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:17 2019-07-23
 * @Desc ：两个线程交替打印 a-z,一个打印元音字母，一个打印辅音字母
 */

public class ConditionTest {



	private static Character c = 'a';

	private static Object lock = new Object();

	private static ReentrantLock reentrantLock = new ReentrantLock();

	private static Condition yuan = reentrantLock.newCondition();
	private static Condition fu = reentrantLock.newCondition();

	private static final Set<Character> ss = new HashSet<Character>();

	static {
		ss.add('a');
		ss.add('e');
		ss.add('i');
		ss.add('o');
		ss.add('u');
	}


	static class Thread1 implements Runnable {
		@Override
		public void run() {

			reentrantLock.lock();
			try {
				while (c <= 'z') {
					//		System.out.println("=====threadName1=" + Thread.currentThread().getName());
					while (ss.contains(c)) {
						System.out.println("=====threadName1=" + Thread.currentThread().getName() + "===char=====" + c);
						c = (char) (c + 1);
						if (c > 'z') {
							break;
						}
					}
					fu.signal();
					yuan.await();
				}

			} catch (Exception e) {
		//		log.info("=====work1 fail");
			} finally {
				reentrantLock.unlock();
			}
		}
	}

	static class Thread2 implements Runnable {
		@Override
		public void run() {
			reentrantLock.lock();
			try {
				while (c <= 'z') {
					//			System.out.println("=====threadName2=" + Thread.currentThread().getName());
					if (ss.contains(c)) {
						yuan.signal();
						fu.await();
					}
					while (!ss.contains(c)) {
						System.out.println("=====threadName2=" + Thread.currentThread().getName() + "===char=" + c);
						c = (char) (c + 1);
						if (c > 'z') {
							break;
						}
					}
				}

			} catch (Exception e) {
		//		log.info("=====work2 fail");
			} finally {
				reentrantLock.unlock();
			}

		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1(), "work1");
		Thread t2 = new Thread(new Thread2(), "work2");

		t1.start();

		t2.start();
	}
}
