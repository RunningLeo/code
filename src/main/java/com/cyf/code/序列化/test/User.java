package com.cyf.code.序列化.test;

import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午3:37 2020/5/17
 * @Desc ：
 */
@ToString
@Data
public class User implements Serializable {

	private Integer id;

	private String name;

	private transient Integer age;

	private final static long serializableVersionId = -6849794470754667710L;


	/**
	 * 自定义实现writeObject
	 *
	 */
	private void writeObject(ObjectOutputStream oos){
		System.out.println("自定义 Serializable writeObject");

		try {
			oos.writeObject(id);
			oos.writeObject("CYF");
			oos.writeObject(age);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/**
	 * 自定义实现readObject
	 */
	private void readObject(ObjectInputStream ois){

		System.out.println("自定义 Serializable readObject");
		try {
			id = (int) ois.readObject();
			name = (String) ois.readObject();
			age = 688;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}
}
