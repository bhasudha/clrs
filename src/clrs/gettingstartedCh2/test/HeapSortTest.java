package clrs.gettingstartedCh2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import clrs.gettingstartedCh2.algorithms.HeapSort;
import clrs.gettingstartedCh2.algorithms.InsertionSort;

public class HeapSortTest {
	HeapSort sort;
	ArrayList<Comparable> input, expected;
	
	public HeapSortTest(){
		 input = new ArrayList<Comparable>();
		 input.add(new Integer(4));
		 input.add(new Integer(1));
		 input.add(new Integer(3));
		 input.add(new Integer(2));
		 input.add(new Integer(16));
		 input.add(new Integer(9));
		 input.add(new Integer(10));
		 input.add(new Integer(14));
		 input.add(new Integer(8));
		 input.add(new Integer(7));
		 sort = new HeapSort();
			 
		 expected = new ArrayList<Comparable>();
		 expected.add(new Integer(1));
		 expected.add(new Integer(2));
		 expected.add(new Integer(3));
		 expected.add(new Integer(4));
		 expected.add(new Integer(7));
		 expected.add(new Integer(8));
		 expected.add(new Integer(9));
		 expected.add(new Integer(10));
		 expected.add(new Integer(14));
		 expected.add(new Integer(16));
	}
	
	@Test
	public void testSort(){
		// Test for a set of Integers
		assertEquals(expected, sort.doSort(input));
		// Test for a set of Floats and integers
		input.set(2, new Float(3.5f));
		input.set(5, new Float(9.3f));
		expected.set(2, new Float(3.5f));
		expected.set(6, new Float(9.3f));
		try{
			sort.doSort(input);
			assertEquals("Should have thrown an Exception since we are mixing datatypes", true, false);
		}
		catch(ClassCastException e){
			
		}
		// Test for a set of Strings
		input.clear();
		expected.clear();
		input.add(new String("vinu"));
		input.add(new String("mridhu"));
		input.add(new String("sudha"));
		input.add(new String("latha"));
		input.add(new String("chandar"));
		expected.add(new String("chandar"));
		expected.add(new String("latha"));
		expected.add(new String("mridhu"));
		expected.add(new String("sudha"));
		expected.add(new String("vinu"));
		assertEquals(expected, sort.doSort(input));
	}
}

