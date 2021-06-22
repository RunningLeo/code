package com.cyf.code.designPatterns.factory.simple_factory;

import com.cyf.code.designPatterns.factory.Apple;
import com.cyf.code.designPatterns.factory.Banana;
import com.cyf.code.designPatterns.factory.Fruit;

/**
 * @desc:
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:27
 */
public class FruitFactory {

    public static Fruit createFruit(Integer type) {

        if(type == 1){
            return new Apple();
        }else {
            return new Banana();
        }
    }
}
