package com.skillsimprover.magicnums.constants;

public class ConstantsAppNotNotNot {

	private static final int MONTH_IN_YEAR = 12;

	private static final int[] MONTH_INDEXES = {
		1,
		2,
		3,
		4,
		5,
		6,
		7,
		8,
		9,
		10,
		11,
		12,
	};

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

	private static final String[] MONTH_CODES = {
		"Jan",
		"Feb",
		"Mar",
		"Apr",
		"May",
		"Jun",
		"Jul",
		"Aug",
		"Sep",
		"Oct",
		"Nov",
		"Dec",
	};

	private static final int[] DAYS_IN_MONTH = {
		31,
		28,
		31,
		30,
		31,
		30,
		31,
		31,
		30,
		31,
		30,
		31
	};

	private static final String[] SEASONS = {
		"Winter",
		"Winter",
		"Spring",
		"Spring",
		"Spring",
		"Summer",
		"Summer",
		"Summer",
		"Autumn",
		"Autumn",
		"Autumn",
		"Winter",
	};

	public static void main(String[] args) {

		for (int i = 0; i < MONTH_IN_YEAR; i++) {
			System.out.println(MONTH_INDEXES[i] + " - " + MONTH_NAMES[i] + " - " + MONTH_CODES[i] + " - Days=" + DAYS_IN_MONTH[i] + " - " + SEASONS[i]);
		}
	}
}




