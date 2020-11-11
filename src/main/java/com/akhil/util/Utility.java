package com.akhil.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

	public static Date getCurrentDate(String dateString) {

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}

	}

	public static long getMillisFromNow(Date date) {
		long time = date.getTime();
		long currentMillis = System.currentTimeMillis();
		return time - currentMillis;
	}

}
