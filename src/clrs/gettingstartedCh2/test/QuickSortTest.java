package clrs.gettingstartedCh2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import clrs.gettingstartedCh2.algorithms.QuickSort;

public class QuickSortTest {
	QuickSort qs;
	ArrayList<Comparable> in, expected;
	
	public QuickSortTest(){
		in = new ArrayList<Comparable>();
		expected = new ArrayList<Comparable>();
		in.add(new Integer(10));
		in.add(new Integer(4));
		in.add(new Integer(29));
		in.add(new Integer(-10));
		in.add(new Integer(15));
		in.add(new Integer(30));
		in.add(new Integer(100));
		in.add(new Integer(11));
		in.add(new Integer(5));
		in.add(new Integer(20));
		in.add(new Integer(91));
		qs = new QuickSort(in);
	}
	
	@Test
	public void testSort(){
		expected.add(new Integer(-10));
		expected.add(new Integer(4));
		expected.add(new Integer(5));
		expected.add(new Integer(10));
		expected.add(new Integer(11));
		expected.add(new Integer(15));
		expected.add(new Integer(20));
		expected.add(new Integer(29));
		expected.add(new Integer(30));
		expected.add(new Integer(91));
		expected.add(new Integer(100));
		assertEquals(expected, qs.doSort(0, in.size() -1));	
	}
	
}
