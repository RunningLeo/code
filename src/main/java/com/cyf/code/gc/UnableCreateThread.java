package com.cyf.code.gc;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:15 2020-01-14
 * @Desc ：
 *
 * ========i=2028
 * ========i=2029
 * ========i=2030
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 * 	at java.lang.Thread.start0(Native Method)
 * 	at java.lang.Thread.start(Thread.java:717)
 * 	at com.cyf.code.gc.UnableCreateThread.main(UnableCreateThread.java:24)
 * Error occurred during initialization of VM
 * java.lang.OutOfMemoryError: unable to create new native thread
 *
 * 一个进程中可以创建的线程是有限的
 *
 * ➜ vim ulimit -u
 * 709
 */
public class UnableCreateThread {

	public static void main(String[] args) {


		for (int i = 0; ; i++) {

			System.out.println("========i="+i);

			new Thread(() -> {
				try {
					Thread.sleep(Integer.MAX_VALUE);
				}catch (InterruptedException e){

				}

			}).start();

		}
	}
}
