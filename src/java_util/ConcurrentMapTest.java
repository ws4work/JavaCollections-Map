package java_util;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapTest {

	public static void main(String[] args) {
		ConcurrentMap map = new ConcurrentHashMap();
		Date date = new Date();
		for (int i = 0; i < 200000; i++) {
			map.put(i, i + 500000);
		}
		// System.out.println(map.get(0));
		Date date2 = new Date();
		System.out.println(date2.getTime() - date.getTime());
	}

}
