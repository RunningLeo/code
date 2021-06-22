package com.cyf.code.threads.timer;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:54 2020-01-11
 * @Desc ：信号量：多线程抢多资源
 */
public class SemaphoreTest {

	public static void main(String[] args) {

		//一共有5个车位
		Semaphore semaphore = new Semaphore(5);


		for (int i = 1; i <= 10; i++) {
			//一共10辆车

			new Thread(() -> {
				Thread thread = Thread.currentThread();
				try {
					semaphore.acquire();
					System.out.println("====第"+thread.getName()+"辆车抢到了车位，time="+ LocalTime.now());
					Thread.sleep(2000);
				}catch (InterruptedException e){

				}finally {
					System.out.println("\n====第"+thread.getName()+"辆车释放了车位");
					semaphore.release();
				}
			}, String.valueOf(i)).start();

		}
	}
}
