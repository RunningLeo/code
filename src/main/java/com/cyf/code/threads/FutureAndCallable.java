package com.cyf.code.threads;

import java.util.concurrent.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:06 2018/12/5
 * @Desc ：
 */
public class FutureAndCallable {

	public static void main(String[] args) throws Exception {
		System.out.println("=====begin="+System.currentTimeMillis()/1000);
		ExecutorService executorService = Executors.newCachedThreadPool();
		int count = 50;
		TaskTest task = new TaskTest(count);
		TaskTest1 taskTest1 = new TaskTest1(count);


		FutureTask<Integer> futureTask = new FutureTask<>(task);
		executorService.submit(futureTask);



		Future<Integer> future = executorService.submit(taskTest1);
		int result = futureTask.get();
		int result1 = future.get();

		System.out.println("=====res="+result);
		System.out.println("=====res1="+result1);
		System.out.println("=====end="+System.currentTimeMillis()/1000);


	}

}

class TaskTest implements Callable<Integer> {

private Integer count;

TaskTest(Integer count){
	this.count = count;

}
	@Override
	public Integer call() throws Exception {
		System.out.println("=====当前5=thread="+Thread.currentThread().getName());
		System.out.println("=====be1="+System.currentTimeMillis()/1000);
		Thread.sleep(2000);
		int sum = count;
		for (int i = 0; i< 100; i++){
			sum += i;
		}
		System.out.println("=====en1="+System.currentTimeMillis()/1000);
		return sum;
	}
}

class TaskTest1 implements Callable<Integer> {

	private Integer count;

	TaskTest1(Integer count){
		this.count = count;

	}

	@Override
	public Integer call() throws Exception {
		System.out.println("=====当前6=thread="+Thread.currentThread().getName());
		System.out.println("=====be2="+System.currentTimeMillis()/1000);
		Thread.sleep(3000);
		int sum = count;
		for (int i = 0; i<= 100; i++){
			sum += i;
		}
		System.out.println("=====en2="+System.currentTimeMillis()/1000);
		return sum;
	}
}



