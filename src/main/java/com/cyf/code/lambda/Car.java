package com.cyf.code.lambda;

import lombok.Data;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:10 2019-11-26
 * @Desc ：
 */
@Data
public class Car {

	private String name;

	private Integer age;

	public Car(String name, Integer age){
		this.name = name;
		this.age = age;
	}

}
