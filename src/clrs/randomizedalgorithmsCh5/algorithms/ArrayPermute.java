package clrs.randomizedalgorithmsCh5.algorithms;

import java.util.Iterator;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import sun.tools.tree.LengthExpression;

/**
 * Describes methods to obtain random permutations of a given array of objects
 * 
 * 
 */
public class ArrayPermute {

	/**
	 * Permutes by randomly generating priorities for each original list and
	 * then pulling elements together in the priority order
	 * 
	 * @param list
	 * @return
	 */
	public static Object[] permuteBySorting(Object[] list) {
		Random random = new Random();
		Object[] permuted = new Object[list.length];
		SortedMap<Integer, Integer> priorityMap = new TreeMap<Integer, Integer>();
		for (int i = 0; i < list.length; i++) {
			priorityMap.put(random.nextInt((int) Math.pow(list.length, 3)), i);
		}
		Iterator<Integer> iterator = priorityMap.keySet().iterator();
		int i = 0;
		while (iterator.hasNext()) {
			permuted[i++] = list[priorityMap.get(iterator.next())];
		}
		return permuted;
	}

	/**
	 * Permutes by randomly swapping two indices in the original array
	 * 
	 * @param list
	 * @return
	 */
	public static Object[] permuteBySwappingInplace(Object[] list) {
		Random random = new Random();
		for (int i = 0; i < list.length; i++) {
			list[i] = list[random.nextInt(list.length - i) + i];
		}
		return list;
	}
}
