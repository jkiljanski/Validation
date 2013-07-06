package mu.validation.utils;

import java.util.Date;
import org.joda.time.LocalDate;

public class DateUtils {

	public static Date midnight(int year, int month, int day) {
		return new LocalDate(year, month, day).toDate();
	}

	public static boolean areDatesEqual(Date date1, Date date2){
		if(date1 == null){
			return false;
		}
		if(date2 == null){
			return false;
		}
		return date1.equals(date2);
	}

}
