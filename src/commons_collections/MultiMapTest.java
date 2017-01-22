package commons_collections;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;

/**
 * MultiMap��һ��key�����Ǽ򵥵�ָ��һ�����󣬶���һ�����
 */

public class MultiMapTest {
	public static void main(String[] args) {
		MultiMap map = new MultiValueMap();
		Date date = new Date();
		for (int i = 0; i < 200000; i++) {
			map.put(i, i + 500000);
			// System.out.println(map.get(0));
		}
		Date date2 = new Date();
		System.out.println(date2.getTime() - date.getTime());

	}

	@Test
	public void testMultiMap() {
		// MultiHashMap�Ѿ�����
		MultiMap giftMap = new MultiHashMap();
		giftMap.put("gift", "�ʻ�");
		giftMap.put("gift", "��ָ");
		giftMap.put("gift", "ɡ");
		List list = (List) giftMap.get("gift");
		System.out.println(list);// [�ʻ�, ��ָ, ɡ]

		MultiMap giftMap2 = new MultiValueMap();
		giftMap2.put("gift", "�ʻ�");
		giftMap2.put("gift", "��ָ");
		giftMap2.put("gift", "ɡ");
		giftMap2.put("boy", "ay");
		giftMap2.put("girl", "al");
		List list2 = (List) giftMap2.get("gift");
		List list3 = (List) giftMap2.get("boy");
		System.out.println(list2);// [�ʻ�, ��ָ, ɡ]
		System.out.println(list3);// [ay]

	}
}
