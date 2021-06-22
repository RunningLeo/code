package com.cyf.code.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:26 2018/11/7
 * @Desc ：
 */
public class ReentrantLockTest implements Runnable {

	public static ReentrantLock reentrantLock = new ReentrantLock(true);

	public static int i = 0;

	@Override
	public void run() {
		for ( int j = 0; j < 100; j++){
			reentrantLock.lock();
			reentrantLock.lock();
			try {
				System.out.println("====current="+Thread.currentThread().getName());
				i++;
			}finally{
				reentrantLock.unlock();
				reentrantLock.unlock();
			}
		}
	}


	public static void main(String[] args) {

		int [] a = new int[]{1,2,3,4,5};
		Arrays.stream(a).map(x-> x=x+1).forEach(System.out::println);
		Arrays.stream(a).forEach(System.out::println);

		ReentrantLockTest test = new ReentrantLockTest();

		Collections.synchronizedList(new ArrayList<>());
		AtomicInteger integer = new AtomicInteger();
		new ConcurrentSkipListMap();
		ConcurrentHashMap map = new ConcurrentHashMap();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
		t2.start();
		try {
			t1.join(10);
			t2.join();
		}catch (InterruptedException e){
			System.out.println("=====exception");
		}
		System.out.println("======i="+i);

	}
}
