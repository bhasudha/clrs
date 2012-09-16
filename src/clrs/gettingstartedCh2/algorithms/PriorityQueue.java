package clrs.gettingstartedCh2.algorithms;

import java.util.ArrayList;

import org.junit.experimental.max.MaxHistory;

public class PriorityQueue {

	ArrayList<Comparable> input;
	int heapSize = -1;

	public PriorityQueue() {
		input = new ArrayList<Comparable>();
	}

	public void insertElement(Comparable e) {
		++heapSize;
		input.add(new Integer(-9999));
		increaseKey(heapSize, e);
	}

	/**
	 * 
	 * @param index
	 *            is the index of the list at which key needs to be increased
	 * @param e
	 *            is the new key
	 */
	public void increaseKey(int index, Comparable e) {
		if (e.compareTo(input.get(index)) > 0) {
			int p;
			Comparable temp;
			input.set(index, e);
			for (int i = parent(index); i >= 0
					&& (input.get(index).compareTo(input.get(i)) > 0); index = i, i = parent(index)) {
				temp = input.get(index);
				input.set(index, input.get(i));
				input.set(i, temp);
			}
		} else
			System.out
					.println("The new key is lesser than the current key. Please try again with a reater value");
		displayHeap();
	}

	public Comparable maxValue() {
		displayHeap();
		return input.get(0);
	}

	/**
	 * returns the max value and also deletes it in the list
	 * 
	 * @return
	 */
	public Comparable extractMaxValue() {
		Comparable ret = input.get(0);
		input.set(0, input.get(heapSize));
		heapSize--;
		maxHeapify(0);
		displayHeap();
		return ret;
	}

	public int left(int i) {
		return ((i + 1) * 2) - 1;
	}

	public int right(int i) {
		return ((i + 1) * 2);
	}

	public int parent(int i) {
		int p = ((i + 1) / 2) - 1;
		return (p >= 0 ? p : 0);
	}

	/**
	 * makes sure that the element is bigger than its left and right child. Else
	 * swaps it with the larger child and continues the process recursively
	 * until the element is placed in the right position in the list(s.t. it is
	 * bigger than its children)
	 * 
	 * @param index
	 *            maxheapify the element at index
	 */
	public void maxHeapify(int index) {
		int l = left(index);
		int r = right(index);
		int largest = index;
		Comparable temp;

		if ((l <= heapSize) && (input.get(index).compareTo(input.get(l)) > 0)) {
			largest = index;
		} else if ((l <= heapSize)
				&& (input.get(index).compareTo(input.get(l)) < 0))
			largest = l;
		if ((r <= heapSize) && (input.get(r).compareTo(input.get(largest)) > 0)) {
			largest = r;
		}
		if (largest != index) {
			temp = input.get(index);
			input.set(index, input.get(largest));
			input.set(largest, temp);
			maxHeapify(largest);
		}

	}

	public void displayHeap() {
		for (int i = 0; i <= heapSize; i++) {
			System.out.println("index " + i + ": " + input.get(i).toString());
		}
	}
	/*
	 * public static void main(String args[]){ PriorityQueue pq = new
	 * PriorityQueue(); Comparable key; key = new Integer(9);
	 * pq.insertElement(key); key = new Integer(17); pq.insertElement(key);
	 * System.out.println(pq.maxValue().toString()); key = new Integer(1);
	 * pq.insertElement(key); pq.increaseKey(2, 45); key = new Integer(97);
	 * pq.insertElement(key); System.out.println(pq.maxValue().toString());
	 * System.out.println(pq.extractMaxValue().toString());
	 * System.out.println(pq.maxValue().toString()); }
	 */
}
