package cn.edu.zucc.supermark.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringUtil {
	public static Boolean isNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidDate(String str) {
	      boolean convertSuccess=true;
	// 指定日期格式为四位年/两位月份/两位日期
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       try {
	// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比�?2007/02/29会被接受，并转换�?2007/03/01
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	          // e.printStackTrace();
	// 如果throw java.text.ParseException或�?�NullPointerException，就说明格式不对
	           convertSuccess=false;
	       }
	       return convertSuccess;
	}
}
