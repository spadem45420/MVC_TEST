package com.acer.nina.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValid {
	public static boolean isPhoneNumberValid(String phoneNumber) {
		boolean isValid = false;

		// Initialize reg ex for phone number.
		String expression = "((/(/d{3}/)|/d{3}-)|(/(/d{4}/)|/d{4}-))?(/d{8}|/ d{7}) ";
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}
}
