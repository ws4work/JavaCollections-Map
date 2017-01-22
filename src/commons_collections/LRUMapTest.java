package commons_collections;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.map.LRUMap;
import org.junit.Test;

/**
 * LRUMap����С�̶���������ͬ���ģ�Ҳ�����̰߳�ȫ��,������Ԫ�ظ��������������󼯺ϸ���ʱ�����ִ��LRU��̭�㷨��
 * ���е�Ԫ����LRUMap�л�������ʹ����������������ʹ�õĻ����Ԫ�ص���ǰ��(LRUMap��ͨ���������洢Ԫ������).
 * ����LRUMap������̭ʱֻ��Ҫɾ���������һ�����ɣ���header.after��ָ��Ԫ�ض���
 * 
 * Ӱ��Ԫ�ص�ʹ������Ĳ�����
 * 
 * 1.put ��������һ������Ԫ�ض������ʾ�ö�������������ʵ� 2.get ������ѵ�ǰ���ʵ�Ԫ�ض�����Ϊ��������ʵģ��ᱻ�Ƶ����ӱ�ͷ
 * 
 * ע����ִ��containsKey��containsValue����ʱ������Ӱ��Ԫ�صķ��������
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
		// ��ΪLRUMap�Ƿ��̰߳�ȫ�����Կ���ʹ��
		// Collections.synchronizedMap(map)����֤�̰߳�ȫ
		Map map = Collections.synchronizedMap(lruMap);
		lruMap.put("boy", "ay");
		lruMap.put("girl", "al");
		lruMap.get("boy");// ���ʹ��
		lruMap.put("person", "person");
		System.out.println(lruMap);// {boy=ay, person=person}
	}
}
