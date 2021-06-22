package com.cyf.code.threads.print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:38 2019-08-30
 * @Desc ：
 */
public class Atomtic_ABC {

	private AtomicInteger ai = new AtomicInteger(0);
	private static final int MAX_SYC_VALUE = 3 * 10;

	private class RunnableA implements Runnable {
		@Override
		public void run() {
			while (ai.get() < MAX_SYC_VALUE-1) {
				if (ai.get() % 3 == 0) {
					System.out.println(Thread.currentThread().getName() + "=======A");
					ai.getAndIncrement();
				}
			}

		}
	}

	private class RunnableB implements Runnable {
		@Override
		public void run() {
			while (ai.get() < MAX_SYC_VALUE) {
				if (ai.get() % 3 == 1) {
					System.out.println(Thread.currentThread().getName() + "=======B");
					ai.getAndIncrement();
				}
			}

		}
	}

	private class RunnableC implements Runnable {
		@Override
		public void run() {
			while (ai.get() < MAX_SYC_VALUE) {
				if (ai.get() % 3 == 2) {
					System.out.println(Thread.currentThread().getName() + "=======C");
					ai.getAndIncrement();
				}
			}

		}
	}


	public static void main(String[] args) {
		Atomtic_ABC atomic_ABC = new Atomtic_ABC();
		ExecutorService service = Executors.newFixedThreadPool(3);

		service.execute(atomic_ABC.new RunnableA());
		service.execute(atomic_ABC.new RunnableB());
		service.execute(atomic_ABC.new RunnableC());

		service.shutdown();
	}
}
