package com.interviewbit.arrays;

import java.util.HashSet;

/**
 *
 * Remove Element
 *
 * Given an array and a value, remove all the instances of that value in the
 * array. Also return the number of elements left in the array after the
 * operation. It does not matter what is left beyond the expected length.
 *
 * Example: If array A is [4, 1, 1, 2, 1, 3]
 * and value elem is 1, then new length is 3, and A is now [4, 2, 3]
 *
 * Try to do it in less than linear additional space complexity.
 *
 *
 */
public class ArrayDuplicates {
	public static void main(String args[]) {
		int[] arr = { 4, 1, 1, 2, 1, 3 };
		ArrayRepeat obj = new ArrayRepeat();
		obj.findDuplicate(arr);
	}

	public void findDuplicate(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int var : arr) {
			if (set.contains(var)) {
				System.out.println(var);
				break;
			} else {
				set.add(var);
			}
		}
	}
}
