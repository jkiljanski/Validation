package mu.validation.utils;

import java.util.Date;
import org.joda.time.LocalDate;

public class DateUtils {

	public static Date midnight(int year, int month, int day) {
		return new LocalDate(year, month, day).toDate();
	}

}
