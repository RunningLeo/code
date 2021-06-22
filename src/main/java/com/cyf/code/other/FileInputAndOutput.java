package com.cyf.code.other;

import java.io.*;

/**
 * @author ：caoyafei
 * @Date ：Created in 上午10:58 2018/11/9
 * @Desc ：
 */
public class FileInputAndOutput {

/**
 * InputStream(输入流):输入流是用来读入数据的。- - - > > >读入
 * OutputStream(输出流):输出流是用来写出数据的。- - - > > >写出
 */

    public static void fileInputStream() throws FileNotFoundException, IOException {
    	File file  = new File("/Users/leo/Desktop/job.txt");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(fis, "gbk");
		BufferedReader br = new BufferedReader(reader);
		String content = "";
		int size = 0;
		//定义一个字节缓冲区
		byte [] bytes = new byte[1024];
		//循环来读取数据
		while ((content = br.readLine()) != null){
		//	content = new String(bytes, 0, size);
			System.out.println("===="+content);
		}
	}


	public static void main(String[] args)throws FileNotFoundException, IOException {
		fileInputStream();
	}
}
