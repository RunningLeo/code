package com.cyf.code.lock.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:46 2020/5/10
 * @Desc ：
 */
public class TestMyExclusiveLock {

//	final MyExclusiveLock myLock = new MyExclusiveLock();
	final ReentrantLock myLock = new ReentrantLock();

	Condition condition = myLock.newCondition();



	private volatile int tickets = 1000;

	public void test() {

		int size = 3;
		Thread[] array = new Thread[size];

		for (int i = 0; i < size; i++) {

			array[i] = new Thread(new Worker(), "thread-" + i);

			array[i].start();
		}
	}

	private class Worker implements Runnable{
		@Override
		public void run() {

			try {
				myLock.lock();

				while(tickets > 0){

					System.out.println("==>threadName=" + Thread.currentThread().getName()
							+ ", 消费后=" + (--tickets));
					condition.signalAll();

					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println("==>threadName=" + Thread.currentThread().getName()+"====要结束了"+tickets);
				condition.signalAll();

			}finally {
				System.out.println("==>threadName=" + Thread.currentThread().getName()+"====释放锁"+tickets);

				myLock.unlock();
			}





		}
	}


	public static void main(String[] args) {
		TestMyExclusiveLock test = new TestMyExclusiveLock();

		test.test();

	}
}
