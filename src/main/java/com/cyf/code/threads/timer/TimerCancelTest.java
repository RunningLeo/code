package com.cyf.code.threads.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：caoyafei
 * @Date ：Created in 09:44 2019-02-24
 * @Desc ：Timer的cancel测试, 为什么i不连续？
 */
public class TimerCancelTest {

	static int i = 0;

	static public class MyTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("正常运行了" + i);

		}
	}


	public static void main(String[] args) {
		while (true) {
			try {
				i++;
				Timer timer = new Timer();
				MyTask task = new MyTask();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = "2019-02-24 09:50:00";
				Date dateRef = sdf.parse(dateString);
				timer.schedule(task, dateRef);
				timer.cancel();

			} catch (Exception pe) {
				pe.printStackTrace();
			}
		}
	}
}
