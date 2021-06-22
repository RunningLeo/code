package com.cyf.code.threads.condition;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:09 2019-11-07
 * @Desc ：condition模拟生产者消费者
 */
@Slf4j
public class ProducerConsumerDemo {

	private final static ReentrantLock LOCK = new ReentrantLock();

	private final static Condition FULL = LOCK.newCondition();

	private final static Condition EMPTY = LOCK.newCondition();


	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		ExecutorService pools = Executors.newFixedThreadPool(10);

		log.info("========start========");

		for (int i = 0; i <3 ; i++) {
			pools.submit(new Producer(list, 8, LOCK));
		}

		for (int i = 0; i <7 ; i++) {
			pools.submit(new Consumer(list, LOCK));
		}

	}


	/**
	 * ***************生产者***************************************************************************
	 */
	static class Producer implements Runnable{

		private List<Integer> list;
		private Integer maxLength;
		private Lock lock;

		public Producer(List<Integer> list, Integer maxLength, Lock lock){
			this.list = list;
			this.maxLength = maxLength;
			this.lock = lock;
		}

		@Override
		public void run() {

			while (true){
				lock.lock();
				try {
					while (list.size() == maxLength){
						log.info("==生产者：{}. 已经达到最大的生产量:{}，进行await", Thread.currentThread().getName(), list.size());
						FULL.await();
						log.info("==生产者：{}. 当前的生产量:{}，进行await", Thread.currentThread().getName(), list.size());
					}

					int data = RandomUtils.nextInt();
					list.add(data);
					EMPTY.signalAll();
				}catch (InterruptedException e){
					log.info("====producer exception");
				}finally {
					lock.unlock();
				}
			}

		}
	}







	/**
	 * ***************消费者***************************************************************************
	 */
	static class Consumer implements Runnable{

		private List<Integer> list;
		private Lock lock;

		public Consumer(List<Integer> list, Lock lock){
			this.list = list;
			this.lock = lock;
		}

		@Override
		public void run() {
			while (true){
				lock.lock();
				try {
					while (list.size() == 0){
						log.info("==消费者：{}. 已经消费完:{}，进行await", Thread.currentThread().getName(), list.size());
						EMPTY.await();
						log.info("==消费者：{}. 当前的生产量:{}，进行await", Thread.currentThread().getName(), list.size());
					}

					int data = list.remove(0);
					log.info("====消费者:{}, 消费数据:{}", Thread.currentThread().getName(), data);
					FULL.signalAll();
				}catch (InterruptedException e){
					log.info("====consumer exception");
				}finally {
					lock.unlock();
				}
			}
		}
	}

}
