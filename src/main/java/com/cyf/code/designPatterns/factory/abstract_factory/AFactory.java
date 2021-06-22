package com.cyf.code.designPatterns.factory.abstract_factory;

import com.cyf.code.designPatterns.factory.abstract_factory.product.ACookies;
import com.cyf.code.designPatterns.factory.abstract_factory.product.AFruit;
import com.cyf.code.designPatterns.factory.abstract_factory.product.Food;

/**
 * @desc: A工厂
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:49
 */
public  class AFactory extends Factory {

    @Override
    Food createFruit() {
        return new AFruit();
    }

    @Override
    Food createCookie() {
        return new ACookies();
    }
}
