package com.cyf.code.designPatterns.factory;

import com.cyf.code.designPatterns.factory.Fruit;

/**
 * @desc:
 * @Author: caoyafei
 * @Date: 2020/9/10 上午10:22
 */
public class Apple implements Fruit {
    @Override
    public void printDetail() {
        System.out.println("this is apple");
    }
}
