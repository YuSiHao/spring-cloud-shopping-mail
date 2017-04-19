package com.ysh.order.util;

import java.time.Clock;

public class DataUtil {


	private static Clock clock = Clock.systemDefaultZone();

	/**
	 * 获取Epoch小时 from the epoch of 1970-01-01T00:00:00Z
	 * 
	 * @return
	 */
	public static Long getEpochHour() {
		return clock.instant().getEpochSecond() / 3600;
	}

}
