package com.cyf.code.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ：caoyafei
 * @Date ：Created in 15:55 2020-01-11
 * @Desc ：主要是累加到一定数量做某事，和countDownLatch相反
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {


//		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
//			System.out.println("===召唤神龙");
//		});

		CyclicBarrier cyclicBarrier = new CyclicBarrier(7);


		for (int i = 1; i <= 7 ; i++) {
			new Thread( () -> {
				Thread thread = Thread.currentThread();
				System.out.println("==收集到第"+thread.getName()+"颗龙珠");
				try {
					cyclicBarrier.await();
				}catch (BrokenBarrierException | InterruptedException e){

				}
			}, String.valueOf(i)).start();
		}


	}
}
