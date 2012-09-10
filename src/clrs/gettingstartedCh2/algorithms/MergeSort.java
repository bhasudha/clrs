package clrs.gettingstartedCh2.algorithms;

import java.util.ArrayList;

public class MergeSort {
	ArrayList<Comparable> input;

	public MergeSort(ArrayList<Comparable> unsortedList) {
		input = unsortedList;
	}

	/*
	 * start - starting postion of the (sub)array to be sorted end - ending
	 * position of the (sub) array to be sorted
	 */
	public ArrayList<Comparable> doSort(int start, int end) {
		int mid = (start + end) / 2;
		if (start >= end)
			return null;
		doSort(start, mid);
		doSort(mid + 1, end);
		merge(start, mid + 1, end);
		return input;
	}

	/**
	 * 
	 * @param left
	 *            - index in input ArrayList indicating left sub array
	 * @param right
	 *            - index in input ArrayList indicating right sub array
	 * @param end
	 *            - index in input ArrayList indicating end of right sub array
	 */
	public void merge(int left, int right, int end) {
		int leftptr = 0, rightptr = 0;
		Comparable l, r;
		// copy the array elements from the main array into two sub arrays
		ArrayList<Comparable> first = new ArrayList<Comparable>();
		ArrayList<Comparable> second = new ArrayList<Comparable>();
		for (int i = 0; i < (right - left); i++) {
			first.add(input.get(left + i));
		}
		for (int i = 0; i < (end - right + 1); i++) {
			second.add(input.get(right + i));
		}

		// While there are elements left in both the arrays
		while ((leftptr < first.size()) && (rightptr < second.size())) {
			l = first.get(leftptr);
			r = second.get(rightptr);
			if (l.compareTo(r) <= 0) {
				input.set(left++, l);
				leftptr++;
			} else {
				input.set(left++, r);
				rightptr++;
			}
		}
		if (leftptr >= first.size()) {
			/*
			 * all element in left array are processed. copy the remaining
			 * elements from right array into the input array
			 */
			for (int i = rightptr; i < second.size(); i++)
				input.set(left++, second.get(i));
		} else if (rightptr >= second.size()) {
			/*
			 * all element in right array are processed. copy the remaining
			 * elements from left array into the input array
			 */
			for (int i = leftptr; i < first.size(); i++)
				input.set(left++, first.get(i));
		}

	}

	/*
	 * public static void main(String args[]) { ArrayList<Comparable> input =
	 * new ArrayList<Comparable>(); input.add(new String("vinu")); input.add(new
	 * String("mridhu")); input.add(new String("sudha")); input.add(new
	 * String("latha")); input.add(new String("chandar")); in.add(new
	 * Integer(9)); in.add(new Integer(1)); in.add(new Integer(7)); in.add(new
	 * Integer(15)); in.add(new Integer(3)); in.add(new Integer(2)); in.add(new
	 * Integer(6)); in.add(new Integer(4)); MergeSort mergeSort = new
	 * MergeSort(input); ArrayList<Comparable> out = mergeSort.doSort(0, 4); for
	 * (Comparable a : out) { System.out.println(a.toString()); } }
	 */
}
