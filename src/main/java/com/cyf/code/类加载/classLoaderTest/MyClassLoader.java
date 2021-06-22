package com.cyf.code.类加载.classLoaderTest;

import java.io.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 17:08 2020-02-28
 * @Desc ：
 */
public class MyClassLoader extends ClassLoader {

	private String name;
	private String path;

	private final static String TARGET_PATH = "/Users/leo/work/code/src/main/java/com/cyf/code/tomcat/classLoaderTest/Hello.class";


	public MyClassLoader(ClassLoader parent, String name, String path) {
		super(parent);
		this.name = name;
		this.path = path;
	}


	private byte[] loadClassData() throws IOException {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		InputStream in = null;

		try {
			in = new FileInputStream(new File(TARGET_PATH));

			int i = 0;

			while ((i = in.read()) != -1) {
				outputStream.write(i);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}

			if (in != null) {
				in.close();
			}

		}

		return outputStream.toByteArray();


	}


	@Override
	protected Class<?> findClass(String name) {

		byte[] data = new byte[0];
		try {
			data = loadClassData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Class clazz = defineClass(data, 0, data.length);
		return clazz;


	}


	@Override
	public Class<?> loadClass(String name) {

		//不用appClassloader加载Object,

		if (name.equals("java.lang.Object")) {
			ClassLoader system = getSystemClassLoader().getParent();

			try {
				return system.loadClass(name);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}


		return findClass(name);


	}


	public static void main(String[] args) {

		MyClassLoader myClassLoader = new MyClassLoader(MyClassLoader.class.getClassLoader(), "MyClassLoader", TARGET_PATH);

		MyClassLoader myClassLoader2 = new MyClassLoader(MyClassLoader.class.getClassLoader(), "MyClassLoader", TARGET_PATH);


		Class clazz1 = null;
		Class clazz2 = null;


		clazz1 = myClassLoader.loadClass("com.cyf.code.类加载.classLoaderTest.Hello");
		clazz2 = myClassLoader2.loadClass("com.cyf.code.类加载.classLoaderTest.Hello");

		System.out.println("====" + (clazz1 == clazz2));


		System.out.println(clazz1.getClassLoader());
		System.out.println(clazz2.getClassLoader());


	}
}
