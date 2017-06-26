package com.hitema.devops.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class Utils {

	private static final Logger LOGGER = Logger.getLogger(Utils.class);

	public static String encode(String data) throws Exception {
		try {
			return new String(MessageDigest.getInstance("MD5").digest(data.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getMessage());
			throw new Exception("Password encoding failed.");
		}
	}

}
