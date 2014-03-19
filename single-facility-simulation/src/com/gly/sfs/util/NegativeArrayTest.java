package com.gly.sfs.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class NegativeArrayTest {

	@Test
	public void test() {
		int firstIndex = -3;
		int lastIndex = 3;
		
		NegativeArray<Integer> array = new NegativeArray<Integer>(-3, 3);
		
		for (int t = firstIndex; t < lastIndex; ++t) {
			array.set(t, t * 10);
		}
		
		for (int t = firstIndex; t < lastIndex; ++t) {
			int a = array.get(t);
			int b = t * 10;
			assertEquals(a, b);
		}
	}

}
