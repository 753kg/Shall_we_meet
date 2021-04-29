
package shallWe.Util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertUtil {
	public static  int covertInt(String param) {
		return Integer.parseInt(param);
	}
	public static double covertDouble(String param) {
		return Double.parseDouble(param);
	}
	public static Date covertDate(String param) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date d=null;
		try {
			d = new Date(sdf.parse(param).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public static Date covertDate2(String param) {
		return Date.valueOf(param);

	}
	
}
