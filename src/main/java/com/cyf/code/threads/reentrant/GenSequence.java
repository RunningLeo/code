package com.cyf.code.threads.reentrant;

import sun.jvm.hotspot.utilities.soql.Callable;

import javax.script.ScriptException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:55 2019-10-11
 * @Desc ：
 */
public class GenSequence implements Runnable {

	private static Integer sequence = -1;

	private static final Lock lock = new ReentrantLock();

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		lock.lock();

		try {
			if (sequence >= 999) {
				sequence = 0;
			} else {
				sequence++;
			}
		} finally {
			lock.unlock();
		}
	}


	public static void main(String[] args) {
		Thread thread1 = new Thread(new GenSequence());

		Thread thread2 = new Thread(new GenSequence());


	}
}
