package com.cyf.code.threads.test;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:03 2019-02-22
 * @Desc ：
 */
public class Task {
	public void doLongTimeTask(){
		synchronized(this){
			for (int i = 0; i < 100; i++) {
				System.out.println("synchronized threadname = "+Thread.currentThread().getName()+" i =" + (i+1));

			}
		}
		System.out.println("");
		for (int i = 0; i < 100; i++) {
			System.out.println("nosynchronized threadname = "+Thread.currentThread().getName()+" i =" + (i+1));
		}
		System.out.println("");

	}
}
