package clrs.gettingstartedCh2.algorithms;

import java.util.ArrayList;

public class QuickSort {
	ArrayList<Comparable> input;
	int p, q, r;
	Comparable pivot;

	public QuickSort(ArrayList<Comparable> inputList) {
		input = inputList;
		p = 0;
		r = input.size() - 1;
	}

	public ArrayList<Comparable> doSort(int p, int r) {
		int q = partition(p, r);
		if (p < q -1)
			doSort(p, q - 1);
		if ((q + 1) < r)
			doSort(q + 1, r);
		return input;
	}

	public void displaySortedList() {
		for (int i = 0; i < input.size(); i++)
			System.out.println(input.get(i).toString() + "  ");
	}

	/**
	 * 
	 * @param p
	 *            starting index of the list to be partitioned
	 * @param r
	 *            ending index of the list to be partitioned
	 * @return the index at which partition needs to happen
	 */
	public int partition(int p, int r) {
		int i, j;
		i = j = p;
		pivot = input.get(r);
		Comparable temp;

		while ((i < r) && (j < r)) {
			if (input.get(i).compareTo(pivot) <= 0 && (i == j)) {
				i++;
				j++;
			} else if ((input.get(j).compareTo(pivot) <= 0) && (i < j)) {
				swap(i, j);
				i++;
				j++;
			} else if ((input.get(j).compareTo(pivot) > 0) && (i <= j)) {
				j++;
			}
		}
		if ((i < j) && (j == r)) {
			swap(i, j);
		}
		return i;
	}

	public void swap(int x, int y) {
		Comparable temp;
		temp = input.get(y);
		input.set(y, input.get(x));
		input.set(x, temp);
	}

	public static void main(String args[]) {
		ArrayList<Comparable> in = new ArrayList<Comparable>();
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
		QuickSort quickSort = new QuickSort(in);
		quickSort.doSort(0, in.size() - 1);
		quickSort.displaySortedList();
	}
}
