package com.thinkgem.jeesite.test;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 *@author luanyu
 *@date 2017年4月23日
 */
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Md5Hash("777777").toString().toUpperCase());
		System.out.println(new Md5Hash("777777").toString());
		System.out.println(new Md5Hash("A").toString());
		System.out.println(new Md5Hash("A").toString().toUpperCase());
		System.out.println(new Md5Hash("a").toString().toUpperCase());

	}

}
