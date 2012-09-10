package clrs.gettingstartedCh2.test;

import java.util.ArrayList;

import org.junit.Test;
import clrs.gettingstartedCh2.algorithms.InsertionSort;
import static org.junit.Assert.assertEquals;

public class InsertionSortTest {
	InsertionSort sort;
	ArrayList<Comparable> input, expected;
	public InsertionSortTest(){
		sort = new InsertionSort();
		input = new ArrayList<Comparable>();
		 input.add(new Integer(9));
		 input.add(new Integer(1));
		 input.add(new Integer(7));
		 input.add(new Integer(15));
		 input.add(new Integer(3));
		 input.add(new Integer(2));
		 input.add(new Integer(6));
		 input.add(new Integer(4));
		 expected = new ArrayList<Comparable>();
		 expected.add(new Integer(1));
		 expected.add(new Integer(2));
		 expected.add(new Integer(3));
		 expected.add(new Integer(4));
		 expected.add(new Integer(6));
		 expected.add(new Integer(7));
		 expected.add(new Integer(9));
		 expected.add(new Integer(15));
	
	}
	
	@Test
	public void testSort(){
		// Test for a set of Integers
		assertEquals(expected, sort.doSort(input));
		// Test for a set of Floats and integers
		input.set(2, new Float(7.5f));
		input.set(5, new Float(2.3f));
		expected.set(5, new Float(7.5f));
		expected.set(1, new Float(2.3f));
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
