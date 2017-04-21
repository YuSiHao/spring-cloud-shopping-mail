package com.ysh.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	// yyyy/MM/dd HH:mm:ss
	public static String getDate() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 可以方便地修改日期格式
		String nowDate = dateFormat.format(now);
		return nowDate;
	}
}
