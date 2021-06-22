package com.cyf.code.designPatterns.factory.abstract_factory;

import com.cyf.code.designPatterns.factory.abstract_factory.product.Food;

/**
 * @desc: 抽象工厂
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:47
 */
public abstract class Factory {

    /**
     * 生产水果
     * @return
     */
    abstract Food createFruit();

    /**
     * 生产饼干
     * @return
     */
    abstract Food createCookie();
}
