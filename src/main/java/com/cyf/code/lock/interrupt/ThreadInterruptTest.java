package com.cyf.code.lock.interrupt;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午6:00 2020/5/10
 * @Desc ：线程中断测试
 */
public class ThreadInterruptTest {


	public static void main(String[] args) {


		//启动子线程
		Thread thread = new Thread(() -> {

			while (!Thread.currentThread().isInterrupted()){

				//先睡眠,睡眠（阻塞）期间如果被中断，则抛异常，并且清空中断标志位
				try {
					Thread.sleep(100);
					System.out.println("====没有异常");
				} catch (InterruptedException e) {

					System.out.println("===>发生中断异常，当前标志位="+Thread.currentThread().isInterrupted());
					e.printStackTrace();

					//抛出异常后，中断被清除，需要重新设置中断标志位，否则while会继续执行
					Thread.currentThread().interrupt();
				}

			}

		}, "t1");

		thread.start();

		try {
			//主线程睡眠，保证子线程运行起来
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//中断子线程，设置标志位
		thread.interrupt();

	}
}
