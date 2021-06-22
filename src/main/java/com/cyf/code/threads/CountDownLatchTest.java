package com.cyf.code.threads;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:50 2020-01-11
 * @Desc ：倒计时
 */
public class CountDownLatchTest {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(6);

		for (int i = 1; i <= 6; i++) {

			new Thread( () -> {
				Thread thread = Thread.currentThread();
				System.out.println("==="+thread.getName()+"=国被灭");
				countDownLatch.countDown();
			}, String.valueOf(i)).start();
		}

		try {
			countDownLatch.await();
		}catch (InterruptedException e){

		}

		System.out.println("===秦国一统");
	}
}
