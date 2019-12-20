package test;

import java.util.*;

import org.junit.Test;

public class TestMap {
    
	@Test
	public void testIterator() {
		// 菱形写法
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("70317", "曲阳");
		hashMap.put("71121", "在东");
		hashMap.put("70333", "商音");
		hashMap.put("80000", "有恒");
		// Set<Map.Entry<K, V>> 
		for (Map.Entry<String, String> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
            System.out.println(key+"="+value);
		}
	}
}
