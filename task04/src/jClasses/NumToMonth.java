package jClasses;

public class NumToMonth {
	public static String create(String numMonth) {
		switch (numMonth) {
		case "01":
			numMonth = "января";
			break;
		case "02":
			numMonth = "февраля";
			break;
		case "03":
			numMonth = "марта";
			break;
		case "04":
			numMonth = "апреля";
			break;
		case "05":
			numMonth = "мая";
			break;
		case "06":
			numMonth = "июня";
			break;
		case "07":
			numMonth = "июля";
			break;
		case "08":
			numMonth = "августа";
			break;
		case "09":
			numMonth = "сентября";
			break;
		case "10":
			numMonth = "октября";
			break;
		case "11":
			numMonth = "ноября";
			break;
		case "12":
			numMonth = "декабря";
			break;
		default:
			break;
		}

		return numMonth;
	}
}
