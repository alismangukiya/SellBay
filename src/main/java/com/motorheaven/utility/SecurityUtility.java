package com.motorheaven.utility;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;
@Component
public class SecurityUtility{
	
	 private String toHexString(byte[] hash)
	    {
	         BigInteger number = new BigInteger(1, hash);
	 
	        // Convert message digest into hex value
	        StringBuilder hexString = new StringBuilder(number.toString(16));
	 
	        // Pad with leading zeros
	        while (hexString.length() < 64)
	        {
	            hexString.insert(0, '0');
	        }
	 
	        return hexString.toString();
	    }
	public String getHashedString(String password) {
		 MessageDigest digest=null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] encodedhash = digest.digest(
		password.getBytes(StandardCharsets.UTF_8));
		String hashPass=toHexString(encodedhash);
		return hashPass;
	}
}
