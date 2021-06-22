package com.cyf.code.designPatterns.factory.factory_method;

import com.cyf.code.designPatterns.factory.Apple;
import com.cyf.code.designPatterns.factory.Fruit;

/**
 * @desc:
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:37
 */
public class AppleFactory implements FruitFactory {

    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
