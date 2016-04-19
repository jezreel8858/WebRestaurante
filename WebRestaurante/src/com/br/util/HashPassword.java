package com.br.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

public class HashPassword {
	public static String convertHash(String hash) throws NoSuchAlgorithmException{

		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		String result = DigestUtils.sha1Hex(mDigest.digest(hash.getBytes()));
		
		return result;
	}
}
