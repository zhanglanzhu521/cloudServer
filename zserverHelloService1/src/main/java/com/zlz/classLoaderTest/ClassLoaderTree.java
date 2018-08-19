package com.zlz.classLoaderTest;

/**
 * @Title :
 * @Description :
 * @Author : zhanglz
 * @Date : 2018-08-19 21:58
 */
public class ClassLoaderTree {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();
		}
	}
}

