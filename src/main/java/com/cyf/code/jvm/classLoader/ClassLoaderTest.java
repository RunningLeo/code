package com.cyf.code.jvm.classLoader;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:00 2019-09-04
 * @Desc ：
 */
@Slf4j
public class ClassLoaderTest {

	public static void main(String[] args) throws Exception {

		MyClassLoader myLoader = new MyClassLoader();

		try {
			EntryTest object0 = (EntryTest)Class.forName("com.cyf.code.jvm.classLoader.EntryTest").newInstance();
			System.out.println(object0.getB());
			Object object = myLoader.loadClass("com.cyf.code.jvm.classLoader.EntryTest").newInstance();
			System.out.println("=====class="+object.getClass());
			boolean flag = object instanceof EntryTest;
			System.out.println("=====flag="+ flag);

		}catch (ClassNotFoundException e){

			log.info("====="+e.getException());
		}

	}




}
