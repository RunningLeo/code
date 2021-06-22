package com.cyf.code.序列化.test;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author ：caoyafei
 * @Date ：Created in 下午4:29 2020/5/17
 * @Desc ：双重检查锁单例模式
 */
@ToString
@Data
public class Singleton implements Serializable {

	private Integer id;

	private String name;

	private transient Integer age;

	//volatile禁止初始化指令重排序
	public static volatile Singleton INSTANCE ;

	private Singleton(){};

	public static Singleton getInstance(){

		if(INSTANCE == null){

			synchronized (Singleton.class){

				if(INSTANCE == null){
					INSTANCE =  new Singleton();
					INSTANCE.setId(10);
					INSTANCE.setName("haha");
					INSTANCE.setAge(22);
					return INSTANCE;
				}
			}
		}

		return INSTANCE;
	}
}
