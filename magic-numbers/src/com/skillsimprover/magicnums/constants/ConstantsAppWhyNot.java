package com.skillsimprover.magicnums.constants;

public class ConstantsAppWhyNot {

	private static final int MONTH_IN_YEAR = 12;

	private static final String[] MONTH_NAMES = {
		"January",
		"February",
		"March",
		"April",
		"May",
		"June",
		"July",
		"August",
		"September",
		"October",
		"November",
		"December",
	};
	
	public static void main(String[] args) {

		for (int i = 0; i < MONTH_IN_YEAR; i++) {
			System.out.println(MONTH_NAMES[i]);
		}
	}
}

