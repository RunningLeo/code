package com.cyf.code.jvm.oops;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午11:46 2020/4/23
 * @Desc ： 指针压缩 -XX:UseCompressedOops, 32位HotSpot VM是不支持UseCompressedOops参数的，只有64位HotSpot VM才支持。
 * OOP（Ordinary Object Pointer，普通对象指针）
 *
 * 当然也不是所有的对象都会被压缩，只有 以下几种的对象才会被压缩:
 * 对象的全局静态变量（类属性）
 * 对象头信息
 * 对象的引用类型
 * 对象数组类型
 * 而以下几种对象则不能被压缩：
 *
 * 指向PermGen的Class对象指针:
 * 局部变量
 * 传参
 * 返回值
 * NULL指针
 *
 *
 * 对象头包括：MarkWord  和 Klass pointer 类型指针， 如果是数组对象，还会包括数组的长度
 */
public class Oops {

	private int a;

	public Oops(Integer a){
		this.a = a;
	}

	public static void main(String[] args) {
		Oops oops = new Oops(1);

		System.out.println(ClassLayout.parseInstance(oops).toPrintable());

		System.out.println();
		System.out.println("==========================================================>");
		System.out.println();

		EmptyObject emptyObject = new EmptyObject();
		System.out.println(ClassLayout.parseInstance(emptyObject).toPrintable());

		System.out.println();
		System.out.println("==========================================================>");
		System.out.println();

		// 声明一个长度为5的数组

		int[] intArr = new int[5];
		System.out.println(ClassLayout.parseInstance(intArr).toPrintable());
	}


	/**
	 * 开启指针压缩
	 *
	 * com.cyf.code.jvm.oops.Oops object internals:
	 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
	 *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)  markword 无锁
	 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)   markword 无锁
	 *       8     4        (object header)                           05 c0 00 f8 (00000101 11000000 00000000 11111000) (-134168571)  klass poinrer
	 *      12     4    int Oops.a                                    1   实例数据
	 * Instance size: 16 bytes
	 * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
	 *
	 *
	 * ==========================================================>
	 *
	 * com.cyf.code.jvm.oops.Oops$EmptyObject object internals:
	 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
	 *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
	 *       8     4        (object header)                           cd dd 00 f8 (11001101 11011101 00000000 11111000) (-134160947)  指针
	 *      12     4        (loss due to the next object alignment)   对齐
	 * Instance size: 16 bytes
	 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
	 *
	 *
	 * ==========================================================>
	 *
	 * [I object internals:
	 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
	 *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
	 *       8     4        (object header)                           6d 01 00 f8 (01101101 00000001 00000000 11111000) (-134217363)
	 *      12     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
	 *      16    20    int [I.<elements>                             N/A
	 *      36     4        (loss due to the next object alignment)
	 * Instance size: 40 bytes
	 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
	 */

	/**
	 * *******************************************************************************************************************
	 */

	/**
	 * 关闭指针压缩
	 *
	 * com.cyf.code.jvm.oops.Oops object internals:
	 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
	 *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
	 *       8     4        (object header)                           68 c5 86 0d (01101000 11000101 10000110 00001101) (226936168)
	 *      12     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *      16     4    int Oops.a                                    1
	 *      20     4        (loss due to the next object alignment)
	 * Instance size: 24 bytes
	 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
	 *
	 *
	 * ==========================================================>
	 *
	 * com.cyf.code.jvm.oops.Oops$EmptyObject object internals:
	 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
	 *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
	 *       8     4        (object header)                           20 eb ab 0d (00100000 11101011 10101011 00001101) (229370656)
	 *      12     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 * Instance size: 16 bytes
	 * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
	 *
	 *
	 * ==========================================================>
	 *
	 * [I object internals:
	 *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE （分别是 16进制、2进制、10进制）
	 *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
	 *       8     4        (object header)                           68 cb 46 0d (01101000 11001011 01000110 00001101) (222743400)
	 *      12     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
	 *      16     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
	 *      20     4        (alignment/padding gap)
	 *      24    20    int [I.<elements>                             N/A
	 *      44     4        (loss due to the next object alignment)
	 * Instance size: 48 bytes
	 * Space losses: 4 bytes internal + 4 bytes external = 8 bytes total
	 *
	 *
	 * Process finished with exit code 0
	 */



	static class EmptyObject {
	}

}
