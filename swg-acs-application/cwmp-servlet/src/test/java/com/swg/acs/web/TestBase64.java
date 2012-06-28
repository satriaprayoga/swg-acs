package com.swg.acs.web;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class TestBase64 {

	@Test
	public void testCodec(){
		String input="SGVsbG8gV29ybGQ";
		byte[] decode64=Base64.decodeBase64(input);
		System.out.println(Arrays.toString(decode64));
		String decodeString=new String(decode64);
		System.out.println(input+" = "+decodeString);
	}
}
