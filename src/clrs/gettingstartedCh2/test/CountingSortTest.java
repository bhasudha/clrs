package clrs.gettingstartedCh2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import clrs.gettingstartedCh2.algorithms.CountingSort;

public class CountingSortTest {
 
	CountingSort countingSort;
	public CountingSortTest(){
	}
	
	@Test
	public void testSort(){
		ArrayList<Integer> in = new ArrayList<Integer>(12);
		in.add(new Integer(9));
		in.add(new Integer(6));
		in.add(new Integer(4));
		in.add(new Integer(7));
		in.add(new Integer(8));
		in.add(new Integer(4));
		in.add(new Integer(6));
		in.add(new Integer(5));
		in.add(new Integer(7));
		in.add(new Integer(8));
		in.add(new Integer(2));
		in.add(new Integer(9));
		countingSort = new CountingSort(in, 9);
		ArrayList<Integer> expected = new ArrayList<Integer>(12);
		expected.add(new Integer(2));
		expected.add(new Integer(4));
		expected.add(new Integer(4));
		expected.add(new Integer(5));
		expected.add(new Integer(6));
		expected.add(new Integer(6));
		expected.add(new Integer(7));
		expected.add(new Integer(7));
		expected.add(new Integer(8));
		expected.add(new Integer(8));
		expected.add(new Integer(9));
		expected.add(new Integer(9));
		assertEquals(expected, countingSort.doSort());
	}
}
