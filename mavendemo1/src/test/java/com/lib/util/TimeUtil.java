package com.lib.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

	public static String getTimeStamp(String pattern) {
		if (pattern==null) {
			pattern = "yyyyMMddHHmmss";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now); 
	}
	public static String getTimeStamp() {
		return getTimeStamp(null);
	}

}
