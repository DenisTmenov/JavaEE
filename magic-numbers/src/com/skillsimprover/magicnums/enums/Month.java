package com.skillsimprover.magicnums.enums;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum Month {

	January (1, "January", "Jan", 31, Season.Winter),

	February (2, "February", "Feb", 28, Season.Winter),

	March (3, "March", "Mar", 31, Season.Spring),

	April (4, "April", "Apr", 30, Season.Spring),

	May (5, "May", "May", 31, Season.Spring),

	June (6, "June", "Jun", 30, Season.Sumer),

	July (7, "July", "Jul", 31, Season.Sumer),

	August (8, "August", "Aug", 31, Season.Sumer),

	September (9, "September", "Sep", 30, Season.Autumn),

	October (10, "October", "Oct", 31, Season.Autumn),

	November (11, "November", "Nov", 30, Season.Autumn),

	December (12, "December", "Dec", 31, Season.Winter),

	Unknown (13, "UnknownMonth", "Unc", 150, Season.Winter);

	
	private final int index;

	private final String name;

	private final String code;

	private final int daysInMonth;

	private final Season season;

	private Month(int index, String name, String code, int daysInMonth, Season season) {
		this.index = index;
		this.name = name;
		this.code = code;
		this.daysInMonth = daysInMonth;
		this.season = season;
	}

	
	
	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public Season getSeason() {
		return season;
	}

	public int getDaysInMonth() {
		if (February.equals(this)) {
			if (isLeapYear()) {
				return 29;
			}

			return 28;
		}

		return daysInMonth;
	}

	public boolean isLeapYear() {
		Date today = new Date();
		GregorianCalendar calendar = (GregorianCalendar)GregorianCalendar.getInstance();
		calendar.setTime(today);

		return calendar.isLeapYear(calendar.get(Calendar.YEAR));
	}
	
	public String getMonthInfo() {
		return index + " - " + name + " - " + code + " - Days=" + getDaysInMonth() + " - " + getSeason();
	}

	public static Month searchMonth(String monthData) {
		// First try to find by Name:
		for (Month month : Month.values()) {
			if (month.name.equals(monthData)) {
				return month;
			}
		}

		// If Month not found, find by Code:
		for (Month month : Month.values()) {
			if (month.code.equals(monthData)) {
				return month;
			}
		}

		// Otherwise, return NULL:
		return Month.Unknown;
	}
}
















