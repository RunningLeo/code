package com.cyf.code.designPatterns.factory.abstract_factory.product;

/**
 * @desc:
 * @Author: caoyafei
 * @Date: 2020/9/10 上午11:12
 */
public class AFruit extends Fruit {

    @Override
    public void printDetail() {
        System.out.println("===>this is AFruit");
    }
}
