package weichun.campus.news;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil
{
	public static Date stringToDate(String dateString)
	{
		ParsePosition position = new ParsePosition(0);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date dateValue = simpleDateFormat.parse(dateString, position);
		return dateValue;
	}
}
