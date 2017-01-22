package commons_collections;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.map.LRUMap;
import org.junit.Test;

/**
 * LRUMap：大小固定。它不是同步的，也不是线程安全的,新增的元素个数大于允许的最大集合个数时，则会执行LRU淘汰算法。
 * 所有的元素在LRUMap中会根据最近使用情况进行排序。最近使用的会放在元素的最前面(LRUMap是通过链表来存储元素内容).
 * 所以LRUMap进行淘汰时只需要删除链表最后一个即可（即header.after所指的元素对象）
 * 
 * 影响元素的使用情况的操作：
 * 
 * 1.put 当新增加一个集合元素对象，则表示该对象是最近被访问的 2.get 操作会把当前访问的元素对象作为最近被访问的，会被移到链接表头
 * 
 * 注：当执行containsKey和containsValue操作时，不会影响元素的访问情况。
 *
 */
public class LRUMapTest {
	public static void main(String[] args) {
		LRUMap map = new LRUMap(100);
		Date date = new Date();
		for (int i = 0; i < 200000; i++) {
			map.put(i, i + 500000);
		}
		// System.out.println(map.get(0));
		Date date2 = new Date();
		System.out.println(date2.getTime() - date.getTime());
	}

	@Test
	public void testLRUMap() {
		LRUMap lruMap = new LRUMap(2);
		// 因为LRUMap是非线程安全，所以可以使用
		// Collections.synchronizedMap(map)来保证线程安全
		Map map = Collections.synchronizedMap(lruMap);
		lruMap.put("boy", "ay");
		lruMap.put("girl", "al");
		lruMap.get("boy");// 最近使用
		lruMap.put("person", "person");
		System.out.println(lruMap);// {boy=ay, person=person}
	}
}
