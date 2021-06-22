package com.cyf.code.序列化.test;

import lombok.extern.slf4j.Slf4j;
import sun.misc.IOUtils;

import java.io.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:37 2020/5/17
 * @Desc ：序列化
 */
@Slf4j
public class MySerializableDemo {

	private final static String SAVE_PATH = "save";


	/**
	 * 序列化方法
	 *
	 * @param t
	 * @param <T>
	 */
	public static <T> void Serializable(T t) {

		//序列化到save文件下
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH));

			oos.writeObject(t);

		} catch (Exception ex) {
			log.info("===>ex={}", ex.getStackTrace());
		} finally {

		}
	}


	/**
	 * 反序列化方法
	 *
	 * @param <T>
	 */
	public static <T> T UnSerializable() {

		//序列化到save文件下
		try {

			File file = new File(SAVE_PATH);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

			T t = (T) ois.readObject();

			return t;

		} catch (Exception ex) {
			log.info("===>ex2={}", ex.getStackTrace());
		} finally {

		}

		return null;
	}


	public static void main(String[] args) {
		User user = new User();
		user.setId(10);
		user.setAge(20);
		user.setName("abc");

		System.out.println("====>序列化前,user="+user.toString());

		//序列化
		Serializable(user);

		//反序列化
		User user1 = UnSerializable();
		System.out.println("====>序列化后,user1="+user1.toString());

		System.out.println();

		System.out.println();


		/**
		 * ===单例模式验证===========================================
		 */
		Singleton singleton = Singleton.getInstance();
		System.out.println("====>序列化前,singleton="+singleton.toString());

		//序列化
		Serializable(singleton);

		//反序列化
		Singleton singleton1 = UnSerializable();
		System.out.println("====>序列化后,singleton1="+singleton1.toString());


		System.out.println("===>singleton=singleton1 ? "+(singleton == singleton1));

		System.out.println("===序列化破坏了单例模式");

	}
}
