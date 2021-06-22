package com.cyf.code.lambda;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：caoyafei
 * @Date ：Created in 19:34 2019-11-26
 * @Desc ：
 */
public class CarFilter {

	public static <T> List<T> filter(List<T> list, CarAgeCheck check){
		if (CollectionUtils.isEmpty(list)){
			return new ArrayList<>(0);
		}

		List<T> result = new ArrayList<>(list.size());
		for(int i=0; i<list.size(); i++){
			T t = list.get(i);
			if (check.test(t)) {
				result.add(t);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<Car> carList = Lists.newArrayList(new Car("aa",23), new Car("bb",26));

		List<Car> filter = CarFilter.filter(carList, c -> ((Car) c).getAge() > 25);

		System.out.println("====filter="+filter);
	}
}
