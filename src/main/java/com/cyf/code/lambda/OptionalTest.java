package com.cyf.code.lambda;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author ：caoyafei
 * @Date ：Created in 16:01 2019-11-21
 * @Desc ：
 */
public class OptionalTest {

	public static void main(String[] args) {


		Optional<Integer> op = Optional.of(12);
		if(op.isPresent()){
			System.out.println("==="+op.get());
		}

		Optional<Integer> op2 = Optional.ofNullable(null);

		System.out.println("====other="+op2.orElse(2));

		System.out.println("====other2="+op2.orElseGet(() -> Integer.valueOf("1")));

		System.out.println("====other3="+op2.orElseThrow(NoSuchElementException::new));








	}
}
