package java_util;

import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections.map.IdentityMap;
import org.junit.Test;

public class IdentityHashMapTest {
	/**
	 * IdentityHashMap�����ַ��ͬ�����������Ϊkeyֵ�� ���仰˵���� IdentityHashMap �У����ҽ���
	 * (k1==k2)ʱ������Ϊ������ k1 �� k2 ��ȡ�
	 */
	public static void main(String[] args) {
		IdentityHashMap map = new IdentityHashMap();
		Date date = new Date();
		for (int i = 0; i < 200000; i++) {
			map.put(i, i + 500000);
		}
		// System.out.println(map.get(0));
		Date date2 = new Date();
		System.out.println(date2.getTime() - date.getTime());
	}

	@Test
	public void testIdentityMap() {
		class Boy {
			private int id;
			private String name;

			public Boy(int id, String name) {
				this.id = id;
				this.name = name;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			@Override
			public String toString() {
				return "Boy{" + "id=" + id + ", name='" + name + '\'' + '}';
			}

			@Override
			public boolean equals(Object o) {
				if (this == o)
					return true;
				if (o == null || getClass() != o.getClass())
					return false;
				Boy boy = (Boy) o;
				if (id != boy.id)
					return false;
				return name != null ? name.equals(boy.name) : boy.name == null;
			}

			@Override
			public int hashCode() {
				int result = id;
				result = 31 * result + (name != null ? name.hashCode() : 0);
				return result;
			}
		}
		// ��ʼ��
		IdentityMap identityMap = new IdentityMap();
		// key����ͬ��boy�����ڴ��ַ��ͬ������������ͬ
		identityMap.put(new Boy(1, "ay"), "ay");
		identityMap.put(new Boy(1, "ay"), "al");
		System.out.println(identityMap);// {Boy{id=1, name='ay'}=al, Boy{id=1,
										// name='ay'}=ay}
		// ��ʼ������map
		Map map = new HashedMap();
		// ��Ϊ��������дhashCode������toString����
		map.put(new Boy(1, "ay"), "ay");
		map.put(new Boy(1, "ay"), "al");
		System.out.println(map);// {Boy{id=1, name='ay'}=al}
	}

}
