package clrs.randomizedalgorithmsCh5.test;

import org.junit.Test;

import clrs.randomizedalgorithmsCh5.algorithms.ArrayPermute;
import static org.junit.Assert.assertEquals;

public class ArrayPermuteTest {
	
	Object[] list;
	
	public ArrayPermuteTest() {
		list = new Object[1000];
		for (int i=0; i < list.length; i++){
			list[i] = new Object();
		}
	}
	
	 @Test
	 public void testPermuteBySorting() {
		 assertEquals(list.length, ArrayPermute.permuteBySorting(list).length);		 
	 }
	 
	 @Test
	 public void testPermuteBySwappingInplace(){
		 assertEquals(list.length, ArrayPermute.permuteBySwappingInplace(list).length); 
	 }
}
