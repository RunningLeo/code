package com.cyf.code.clone;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;

/**
 * @author ：caoyafei
 * @Date ：Created in 14:12 2019-08-27
 * @Desc ：对象拷贝
 */
@Slf4j
public class ClientTest {

	public static void main(String[] args) {
		Person person = new Person();
		Address address = new Address("henan", "zhengzhou");

		person.setName("zhangsan");
		person.setAddress(address);

		//clone***********************************************************************************

		try {
			Person p1 =  (Person) person.clone();

			p1.setName("lisi");
		//	Address add = (Address) p1.getAddress().clone();
			Address add = p1.getAddress();
			add.setProvince("guanzghou");
			p1.setAddress(add);

			System.out.println("======"+(person == p1));
		}catch (CloneNotSupportedException cne){
			log.info("======CloneNotSupportedException");
		}

		//Serializable******************************************************************************
		//需要都实现Serializable接口
		Person p2 = SerializationUtils.clone(person);
		p2.getAddress().setProvince("guangxi");
		System.out.println("======"+(person == p2));

		//jackson******************************************************************************
		//需要类有无参构造函数
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Person p3 = objectMapper.readValue(objectMapper.writeValueAsString(person), Person.class);
			p3.getAddress().setProvince("beijing");
			System.out.println("======"+(person == p3));

		}catch (Exception e){
			log.info("=======");
		}



	}
}
