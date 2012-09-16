package clrs.gettingstartedCh2.algorithms;

import java.util.ArrayList;

public class HeapSort {
	ArrayList<Comparable> in;

	int lengthOfInput, heapSize;

	public HeapSort() {

	}

	/**
	 * 
	 * @param i
	 *            is the absolute index of the number in the ArrayList.(can be
	 *            0)
	 * @return
	 */
	public int left(int i) {
		return (2 * (i + 1)) - 1;
	}

	/**
	 * 
	 * @param i
	 *            is the absolute index of the number in the ArrayList.(can be
	 *            0)
	 * @return
	 */
	public int right(int i) {
		return ((i + 1) * 2);
	}

	/**
	 * Works on the original Array initialised in the constructor.
	 * 
	 * @param index
	 *            is the position in the array starting at 0!!!!
	 */
	public void maxHeapify(int index) {
		int l = left(index);
		int r = right(index);
		int largest = index;
		Comparable temp;
		if ((l <= heapSize) && (in.get(l).compareTo(in.get(index)) > 0))
			largest = l;
		else
			largest = index;
		if ((r <= heapSize) && (in.get(r).compareTo(in.get(largest)) > 0))
			largest = r;
		if (largest != index) {
			temp = in.get(index);
			in.set(index, in.get(largest));
			in.set(largest, temp);
			maxHeapify(largest);
		}
	}

	public void buildMaxHeap() {
		for (int i = (lengthOfInput - 1) / 2; i >= 0; i--)
			maxHeapify(i);
	}

	public ArrayList<Comparable> doSort(ArrayList<Comparable> input) {
		Comparable temp;
		in = input;
		lengthOfInput = in.size();
		heapSize = lengthOfInput - 1;
		buildMaxHeap();
		for (int i = lengthOfInput - 1; i > 0; i--) {
			temp = in.get(0);
			in.set(0, in.get(heapSize));
			in.set(heapSize, temp);
			heapSize -= 1;
			maxHeapify(0);

		}
		return in;
	}

	/*public static void main(String args[]) {
		ArrayList<Comparable> input = new ArrayList<Comparable>();
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

		input.clear();
		input.add(new String("vinu"));
		input.add(new String("mridhu"));
		input.add(new String("sudha"));
		input.add(new String("latha"));
		input.add(new String("chandar"));

		HeapSort heapSort = new HeapSort();
		ArrayList<Comparable> out = heapSort.doSort(input);
		for (int i = 0; i < out.size(); i++) {
			System.out.println(out.get(i).toString());
		}
	}
*/}
