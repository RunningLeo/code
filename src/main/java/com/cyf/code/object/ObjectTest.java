package com.cyf.code.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:21 2019-12-21
 * @Desc ：
 */
public class ObjectTest {

	public static void main(String[] args) {
		Integer a = 10;

		Size size = new Size();
		String info = ClassLayout.parseInstance(a).toPrintable();
		System.out.println(info);


		System.out.println("==========================================");
		String info2 = ClassLayout.parseInstance(size).toPrintable();



		System.out.println(info2);
	}



	static class Size{
		private Integer sate;

		private boolean flag;
	}


}
