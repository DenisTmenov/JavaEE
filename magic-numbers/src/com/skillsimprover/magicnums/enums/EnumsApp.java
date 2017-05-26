package com.skillsimprover.magicnums.enums;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class EnumsApp {

	public static void main(String[] args) throws IOException {

		readProperties();
		
		System.exit(0);
		
		Month[] monthArray = Month.values();
		for (Month month : monthArray) {
			System.out.println(month);
			System.out.println(month.getMonthInfo());
		}
		
		System.out.println("********************************************");
		Month codeMonth = Month.searchMonth("Apr");
		System.out.println(codeMonth.getMonthInfo());

		System.out.println("********************************************");
		Month nameMonth = Month.searchMonth("December");
		System.out.println(nameMonth);
		
		System.out.println("********************************************");

		String envVar = System.getenv("Month_For_Search");
		Month nameFromConfig = Month.searchMonth(envVar);
		System.out.println(nameFromConfig);
	}

	private static void readProperties() throws IOException {
		String propsPath = "com/skillsimprover/magicnums/config/config.properties";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream stream = classLoader.getResourceAsStream(propsPath);

		Properties properties = new Properties();
		properties.load(stream);

		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			Object value = properties.get(key);
			System.out.println(key + " - " + value);
		}
		
		String firstTry = properties.getProperty("secret-key");
		String secondTry = properties.getProperty("secretkey", "Denis, you will win next time!!!!!!!!");

		System.out.println(firstTry);
		System.out.println(secondTry);
	}
}






