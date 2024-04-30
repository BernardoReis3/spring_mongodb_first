package com.example.spring_mongo_first.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class EncodeURL {
	
	public static String decodeURL(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
