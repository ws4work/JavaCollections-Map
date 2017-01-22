package commons_collections;

import java.util.Date;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.collections.map.MultiKeyMap;
import org.junit.Test;

/**
 * 根据API文档，MultiKeyedMap可以通过下面方式进行什么：
 * 
 * 创建一个排序的map 
 * MultiKeyMap.decorate(new LinkedMap()) creates an ordered map.
 * MultiKeyMap.decorate(new LRUMap()) creates an least recently used map.
 * MultiKeyMap.decorate(new ReferenceMap()) creates a garbage collector sensitive map.
 *
 */
public class MultiKeyedMapTest {
	public static void main(String[] args) {
		MultiKeyMap map = new MultiKeyMap();
		Date date = new Date();
		for (int i = 0; i < 200000; i++) {
			map.put(i, i + 1, i + 2, i + 500000);
		}
		// System.out.println(map.get(0));
		Date date2 = new Date();
		System.out.println(date2.getTime() - date.getTime());
	}
	
	@Test
    public void testMultiKeyMap(){
        //初始化类
        MultiKeyMap multiKeyMap = MultiKeyMap.decorate(new LinkedMap());
        multiKeyMap.put(1,1,2,"112");
        multiKeyMap.put(1,1,3,"113");
        multiKeyMap.put(1,2,1,"121");
        multiKeyMap.put(1,2,2,"122");
        multiKeyMap.put(1,3,1,"131");
        //查找一个值:由1，1，2这3个key可以获得唯一的value值
        String value = (String)multiKeyMap.get(1,1,2);
        System.out.println("value is : " + value);//value is : 112
        String value3 = (String)multiKeyMap.get(2,1,1);
        System.out.println("value3 is : " + value3);//value3 is : null
        String value2 = (String)multiKeyMap.get(1,2,1);
        System.out.println("value2 is " + value2);//value2 is 121
        Object object1 = multiKeyMap.get(1);
        System.out.println("object1 is : " + object1);//object1 is : null
        Object object2 = multiKeyMap.get(1,2);
        System.out.println("object2 is : " + object2);//object2 is : null
    }
}
