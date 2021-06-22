package com.cyf.code.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author ：caoyafei
 * @Date ：Created in 11:05 2019-11-20
 * @Desc ：
 */
public class SupplierTest {

	private Integer code;

	public SupplierTest(){
	}

	public SupplierTest(Integer code){

		this.code = code;
	}

	public static void main(String[] args) {
		Supplier<SupplierTest> supplier = SupplierTest::new;

		Consumer<Integer> consumer = (i) -> new SupplierTest(i);
		consumer.accept(1);

		Consumer<Integer> supplier2 = SupplierTest::new;
		supplier2.accept(2);



	}
}
