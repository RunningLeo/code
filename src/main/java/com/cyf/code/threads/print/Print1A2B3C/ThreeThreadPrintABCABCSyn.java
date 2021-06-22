package com.cyf.code.threads.print.Print1A2B3C;

/**
 * @author ：caoyafei
 * @Date ：Created in 10:34 2019-12-25
 * @Desc ：
 */
public class ThreeThreadPrintABCABCSyn {

	volatile static Integer queue = 1;

	final static int count = 5;


	public static void main(String[] args) {

		final Object o = new Object();

		new Thread(() -> {
			synchronized (o) {
				for (int i = 0; i < count; i++) {
					if (queue == 1) {
						System.out.println(Thread.currentThread().getName() + "======>A");
						queue = 2;
						o.notifyAll();
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}else {
						i--;
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}
				}
				o.notifyAll();
			}
		}, "t1").

				start();



		new

				Thread(() ->

		{
			synchronized (o) {
				for (int i = 0; i < count; i++) {
					if (queue == 2) {
						System.out.println(Thread.currentThread().getName() + "======>B");
						queue = 3;
						o.notifyAll();
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}else {
						i--;
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}

				}
				o.notifyAll();
			}
		}, "t2").

				start();

		new

				Thread(() ->

		{
			synchronized (o) {
				for (int i = 0; i < count; i++) {
					if (queue == 3) {
						System.out.println(Thread.currentThread().getName() + "======>C");
						queue = 4;
						o.notifyAll();
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}else {
						i--;
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}

				}
				o.notifyAll();
			}
		}, "t3").

				start();



		new Thread(() -> {
			int i = 0;
			synchronized (o) {
				while (i < 5){
					if (queue == 4) {
						System.out.println(Thread.currentThread().getName() + "======>D");
						queue = 1;
						o.notifyAll();
						i++;
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}else {
						try {
							o.wait();
						} catch (InterruptedException e) {

						}
					}
				}
				o.notifyAll();
			}
		}, "t4").

				start();

	}



}
