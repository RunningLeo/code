package com.cyf.code.designPatterns.factory.abstract_factory;

import com.cyf.code.designPatterns.factory.abstract_factory.product.BCookies;
import com.cyf.code.designPatterns.factory.abstract_factory.product.BFruit;
import com.cyf.code.designPatterns.factory.abstract_factory.product.Food;

/**
 * @desc: B工厂
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:46
 */
public class BFactory extends Factory {

    @Override
    Food createFruit() {
        return new BFruit();
    }

    @Override
    Food createCookie() {
        return new BCookies();
    }
}
