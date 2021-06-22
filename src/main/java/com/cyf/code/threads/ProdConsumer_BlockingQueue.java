package com.cyf.code.threads;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:32 2020-01-13
 * @Desc ：生产者 消费者 阻塞队列版
 */
public class ProdConsumer_BlockingQueue {

	public static void main(String[] args) {

		MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

		new Thread(() -> {

			try {
				myResource.prod();
			}catch (Exception e){
			}

		}, "Prod").start();

		new Thread(() -> {

			try {
				myResource.consumer();
			}catch (Exception e){
			}

		}, "Consumer").start();


		try {
			Thread.sleep(5000);
		}catch (InterruptedException e){

		}

		System.out.println("======主线程等待5秒，关闭生产消费");
		myResource.stop();


	}


}


class MyResource {

	private volatile boolean FLAG = true;

	private AtomicInteger atomicInteger = new AtomicInteger();

	private BlockingQueue<String> blockingQueue = null;


	public MyResource(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
		System.out.println("===" + blockingQueue.getClass().getName());
	}


	public void prod() throws Exception {

		String data ;
		boolean result;

		while (FLAG) {

			data = atomicInteger.incrementAndGet() + "";

			result = blockingQueue.offer(data, 1, TimeUnit.SECONDS);

			if(result){
				System.out.println("======"+Thread.currentThread().getName()+"===添加数据成功："+data);
			}else {
				System.out.println("======"+Thread.currentThread().getName()+"===添加数据失败："+data);
			}

			try {
				Thread.sleep(1000);
			}catch (InterruptedException e){

			}
		}

	}



	public void consumer() throws Exception {

		String data ;

		while (FLAG) {

			System.out.println("=1===="+System.currentTimeMillis());

			data = blockingQueue.poll( 3, TimeUnit.SECONDS);

			if(StringUtils.isNoneBlank(data)){
				System.out.println("======"+Thread.currentThread().getName()+"===取数据成功："+data);
			}else {
				System.out.println("======"+Thread.currentThread().getName()+"===取数据失败："+data);
				FLAG = false;

			}

		}
	}

	public void stop(){
		FLAG = false;
		System.out.println("==stop=time=="+System.currentTimeMillis());
	}

}
