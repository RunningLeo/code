package com.cyf.code.lock.spin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:45 2020-01-11
 * @Desc ：手写自旋锁
 */
@Slf4j
public class SpinLock {

	private AtomicReference<Thread> reference = new AtomicReference<>();


	public void myLock(){

		Thread thread = Thread.currentThread();
		log.info("={}==={} get lock", System.currentTimeMillis(), thread.getName());
		while (!reference.compareAndSet(null, thread)){
		}
	}


	public void unLock(){
		Thread thread = Thread.currentThread();
		log.info("={}==={} release lock", System.currentTimeMillis(), thread.getName());

		reference.compareAndSet(thread, null);
	}


	public static void main(String[] args) {

		SpinLock spinLock = new SpinLock();

		new Thread(() -> {
			spinLock.myLock();

			try {
				Thread.sleep(5000);
			}catch (InterruptedException e){

			}

			spinLock.unLock();

		}, "AA").start();


		//休息1s，确定AA先拿到锁
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e){

		}

		new Thread(() -> {
			spinLock.myLock();

			try {
				Thread.sleep(1000);
			}catch (InterruptedException e){

			}

			spinLock.unLock();

		}, "BB").start();
	}
}
