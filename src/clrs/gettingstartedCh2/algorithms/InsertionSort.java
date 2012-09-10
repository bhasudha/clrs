package clrs.gettingstartedCh2.algorithms;

import java.util.ArrayList;
import java.util.List;


public class InsertionSort {
       
	public ArrayList<Comparable> doSort(ArrayList<Comparable> input){
		//ArrayList<Comparable<Object>> output = new ArrayList<Comparable<Object>>();
		int left = 0, right = 0;
		Comparable temp;
		for(int i = 1; i < input.size(); i++){
			temp = input.get(i);
			right = i;
			left = right - 1;
			while ((left >= 0) && (input.get(left).compareTo(temp) > 0 )){
				input.set(right--, input.get(left--));
			}
			input.set(++left, temp);
		}
		return input;
	}
	 /*public static void main(String args[]){
		 ArrayList<Comparable> input = new ArrayList<Comparable>();
		 input.add(new Integer(9));
		 input.add(new Integer(1));
		 input.add(new Integer(7));
		 input.add(new Integer(15));
		 input.add(new Integer(3));
		 input.add(new Integer(2));
		 input.add(new Integer(6));
		 input.add(new Integer(4));
		 InsertionSort insertSort = new InsertionSort();
		 insertSort.doSort(input);
		 for (Comparable a : input) {
			System.out.println(a.toString());
		}
	 }*/
}
