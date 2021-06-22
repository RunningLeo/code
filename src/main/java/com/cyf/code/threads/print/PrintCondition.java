package com.cyf.code.threads.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:01 2020-01-13
 * @Desc ：启动三个线程，A->B->C， 要求A打印1次，B 打印2次，C打印3次，一共5轮
 */
public class PrintCondition {


	static Lock lock = new ReentrantLock();
	static Condition condition1 = lock.newCondition();
	static Condition condition2 = lock.newCondition();
	static Condition condition3 = lock.newCondition();

	static volatile String current = "A";

	public static void main(String[] args) {

		PrintCondition printCondition = new PrintCondition();

		new Thread(() -> {
			lock.lock();
			try {

				for (int i = 1; i<= 5; i++){
					while (!current.equals(Thread.currentThread().getName())){
						condition1.await();
					}

					System.out.println(Thread.currentThread().getName()+" print: "+ i);
					current = "B";
					condition2.signal();
					condition1.await();
				}

				condition2.signalAll();

			}catch (InterruptedException e){

			}finally {
				lock.unlock();
			}

		}, "A").start();

		new Thread(() -> {
			lock.lock();
			try {

				for (int i = 1; i<= 5; i++){
					while (!current.equals(Thread.currentThread().getName())){
						condition1.await();
					}

					System.out.println(Thread.currentThread().getName()+" print: "+ i);
					System.out.println(Thread.currentThread().getName()+" print: "+ i);
					current = "C";

					condition3.signal();
					condition2.await();
				}

				condition3.signalAll();

			}catch (InterruptedException e){

			}finally {
				lock.unlock();
			}

		}, "B").start();


		new Thread(() -> {
			lock.lock();
			try {
				for (int i = 1; i<= 5; i++){
					while (!current.equals(Thread.currentThread().getName())){
						condition1.await();
					}
					System.out.println(Thread.currentThread().getName()+" print: "+ i);
					System.out.println(Thread.currentThread().getName()+" print: "+ i);
					System.out.println(Thread.currentThread().getName()+" print: "+ i);
					current = "A";

					condition1.signal();
					condition3.await();
				}

				condition1.signalAll();

			}catch (InterruptedException e){

			}finally {
				lock.unlock();
			}

		}, "C").start();


	}
}
