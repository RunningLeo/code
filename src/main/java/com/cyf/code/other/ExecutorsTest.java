package com.cyf.code.other;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:47 2019-08-13
 * @Desc ：
 */
public class ExecutorsTest {

	public static void test(){
//		ExecutorService executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
//			@Override
//			public Thread newThread(Runnable r) {
//				return new Thread();
//			}
//		});



		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("work-%d").setPriority(10).build();

		ExecutorService executorService1  = new ThreadPoolExecutor(3, 10, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20){}, threadFactory, new ThreadPoolExecutor.AbortPolicy());

		for (int i = 0; i <30 ; i++) {
			executorService1.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"=======work="+System.currentTimeMillis());
					try {
						Thread.sleep(200);
					}catch (Exception e){
						System.out.println("======");
					}
				}
			});
		}

	}


	public static void main(String[] args) {
		ExecutorsTest.test();
	}
}
