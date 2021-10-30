package com.amazon.core.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTimeExamples {

	private static final ThreadLocal<DateFormat> formatters = new ThreadLocal<DateFormat>() {
		protected DateFormat initialValue() {
			return new SimpleDateFormat("dd-MMM-yyyy");
		}
	};

}
