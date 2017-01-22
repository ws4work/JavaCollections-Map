package commons_collections;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;

/**
 * MultiMap：一个key不在是简单的指向一个对象，而是一组对象
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
		// MultiHashMap已经废弃
		MultiMap giftMap = new MultiHashMap();
		giftMap.put("gift", "鲜花");
		giftMap.put("gift", "戒指");
		giftMap.put("gift", "伞");
		List list = (List) giftMap.get("gift");
		System.out.println(list);// [鲜花, 戒指, 伞]

		MultiMap giftMap2 = new MultiValueMap();
		giftMap2.put("gift", "鲜花");
		giftMap2.put("gift", "戒指");
		giftMap2.put("gift", "伞");
		giftMap2.put("boy", "ay");
		giftMap2.put("girl", "al");
		List list2 = (List) giftMap2.get("gift");
		List list3 = (List) giftMap2.get("boy");
		System.out.println(list2);// [鲜花, 戒指, 伞]
		System.out.println(list3);// [ay]

	}
}
