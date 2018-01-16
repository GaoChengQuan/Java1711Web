package com.situ.day40;

import org.junit.Test;

import com.situ.student.util.MD5Util;

public class MD5Test {
	@Test
	public void test1() {
		String str = "abc";
		System.out.println(MD5Util.EncodeUtf8(str));
		//900150983cd24fb0d6963f7d28e17f72
	}
	
	@Test
	public void test2() {
		String str = "^*&(#$@$dHFD)_+!$+";
		System.out.println(MD5Util.EncodeUtf8(str));
	}
	
	@Test
	public void test3() {
		String str = "abc";
		System.out.println(MD5Util.EncodeUtf8AddSalt(str));
	}
}
