package com.example.spring_mongo_first.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class EncodeURL {
	
	public static String decodeURL(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate(String dateText, Date defaultDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(dateText);
		} catch (ParseException e) {
			return defaultDate;
		}
	}

}
