package com.blt.shoppingServer.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;


public class UserTokenUtil {
	private static HashMap<String, HashMap<String,Object>> userMap = new HashMap<String, HashMap<String,Object>>();
	private static String lifeCylce = "1800";
	public static void setUserSession(String token,HashMap<String, Object> userHashMap) {
		long expireTime = System.currentTimeMillis() + Integer.parseInt(lifeCylce) * 1000;
		userHashMap.put("expireTime", expireTime);
		userMap.put(token,userHashMap);
		long nowTime = System.currentTimeMillis();
		if (System.currentTimeMillis() % 1800000 == 0) {
			cleanExpireSession();
		}
	}

	public static void delUserSession(String token) {
		userMap.remove(token);
	}
	public static boolean isUserSession(String token)
	{
		return userMap.containsKey(token);
	}
	public static boolean getUserSession(String token) {
		boolean flag = false;

		String userExpireTime = userMap.get(token).get("expireTime").toString();
		if (userExpireTime != null) {
			long expireTime = Long.parseLong(userExpireTime);

			if (System.currentTimeMillis() > expireTime) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}
	public static String getUserId(String token)
	{
		return userMap.get(token).get("userId").toString();
	}
	@Scheduled(cron=" */30 * * * * *")
	public static void cleanExpireSession() {
		for (Iterator<Entry<String, HashMap<String, Object>>> it = userMap.entrySet().iterator(); it.hasNext();) {
			Entry<String, HashMap<String, Object>> item = it.next();
			long expireTime = Long.parseLong((String)userMap.get(item.getKey()).get("expireTime"));
			if (System.currentTimeMillis() > expireTime) {
				it.remove();
			}
		}
	}
}