package com.cyf.code.threads.print.Print1A2B3C;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:52 2019-12-24
 * @Desc ：singal wait
 */
@Slf4j
public class Print1A2BWaitSingal {

	static Thread t1;
	static Thread t2;



	public static void main(String[] args) {

		final Object o = new Object();


		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o){
					for (int i = 1; i<= 26; i++){
						System.out.print(i);
						o.notify();
						try {
							o.wait();
						}catch (InterruptedException e){
							log.info("=====t1 fail");
						}

					}
					o.notify();
				}
			}
		});

		t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (o){
					for (char c = 'A'; c <= 'Z'; c++){

						System.out.print(c);
						o.notify();

						try {
							o.wait();
						}catch (InterruptedException e){
							log.info("=====t2 fail");
						}

					}
					o.notify();
				}
			}
		});

		t1.setName("t1");
		t2.setName("t2");

		t1.start();
		t2.start();





	}
}
