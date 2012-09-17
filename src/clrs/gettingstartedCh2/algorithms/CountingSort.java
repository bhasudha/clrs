package clrs.gettingstartedCh2.algorithms;

import java.util.ArrayList;

public class CountingSort {
	ArrayList<Integer> input, count, output;
	int range;

	public CountingSort(ArrayList<Integer> in, int range) {
		input = in;
		this.range = range;
	}

	public ArrayList<Integer> doSort() {
		count = new ArrayList<Integer>(range + 1);
		// Initialize count Array to 0
		for (int i = 0; i <= range; i++) {
			count.add(new Integer(0));
		}

		output = new ArrayList<Integer>(input.size());
		Integer temp;

		// count the occurrence of each item in input list in the count list.
		// count[10] = 2 means the number 10 has occurred twice in the input
		// list
		// Also initialise output array to 0
		for (int i = 0; i < input.size(); i++) {
			temp = input.get(i);
			count.set(temp, count.get(temp) + 1);
			output.add(0);
		}

		// Calculate running total in the count array. this determines the
		// starting position of each item in the output array
		int total = 0;
		for (int i = 0; i < count.size(); i++) {
			total += count.get(i);
			count.set(i, total);
		}

		// put the numbers from input array into the output array according to
		// count array
		int cntIndex, outIndex;
		for (int j = 0; j < input.size(); j++) {
			cntIndex = input.get(j);
			outIndex = count.get(cntIndex);
			if (outIndex != 0)
				output.set(outIndex - 1, cntIndex);
			count.set(cntIndex, outIndex - 1);
		}
		return output;
	}

	public void display() {
		for (int i = 0; i < output.size(); i++)
			System.out.println(output.get(i).toString());
	}

	/*public static void main(String args[]) {
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
		CountingSort countingSort = new CountingSort(in, 9);
		countingSort.doSort();
		countingSort.display();
	}*/
}
