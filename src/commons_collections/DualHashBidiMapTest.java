package commons_collections;

import java.util.Date;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;
import org.junit.Test;

/**
 * DualHashBidiMap可以通过key找到value，也可以通过value找到key
 */
public class DualHashBidiMapTest {
	public static void main(String[] args) {
		DualHashBidiMap map = new DualHashBidiMap();
		Date date = new Date();
		for (int i = 0; i < 200000; i++) {
			map.put(i, i + 500000);
			// System.out.println(map.get(i));
		}
		Date date2 = new Date();
		System.out.println(date2.getTime() - date.getTime());
	}

	@Test
	public void testDualHashBidiMap() {
		// 双向map
		BidiMap bidiMap = new DualHashBidiMap();
		bidiMap.put("Ay", "Boy");
		bidiMap.put("Al", "Girl");
		System.out.println("Key-Value:Ay = " + bidiMap.get("Ay"));// Key-Value:Ay
																	// = Boy
		System.out.println("Value-Key:Gril = " + bidiMap.getKey("Girl"));// Value-Key:Gril
																			// =
																			// Al
	}
}
