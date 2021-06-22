package com.cyf.code.threads.test;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:03 2019-02-22
 * @Desc ：
 */
public class ThreadF extends Thread{

	private Task task;

	public ThreadF(Task task){
		super();
		this.task = task;
	}

	@Override
	public void run() {

		task.doLongTimeTask();
	}
}
