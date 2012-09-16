package clrs.gettingstartedCh2.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import clrs.gettingstartedCh2.algorithms.PriorityQueue;

public class PriorityQueueTest {
	PriorityQueue queue;
	public PriorityQueueTest(){
		queue = new PriorityQueue();
	}
	
	@Test
	public void testPriorityQueue(){
		Comparable key;
		key = new Integer(9);
		queue.insertElement(key);
		key = new Integer(17);
		queue.insertElement(key);
		assertEquals(new Integer(17), queue.maxValue());
		key = new Integer(1);
		queue.insertElement(key);
		key = new Integer(13);
		queue.increaseKey(2, 45);
		assertEquals(new Integer(45), queue.maxValue());
		key = new Integer(189);
		queue.insertElement(key);
		assertEquals(new Integer(189), queue.extractMaxValue());
		assertEquals(new Integer(45), queue.maxValue());
	}
}
