package com.interviewbit.twopointers;

import java.util.Arrays;

/**
 * Given an array S of n integers, find 2 integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 *
 * Assume that there will only be one solution
 *
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 = 1)
 *
 */

public class Array2Sum {
    final static int target = -3;
    final static int []arr = {-1, 2, 1, -4};

    public static void main (String args[]) {
        new Array2Sum().twoSum();
    }

    public void twoSum() {
        System.out.println("yo");
        int start = 0;
        int end = arr.length-1;
        int currentSum = 0;
        int prevSum = 0;

        // sort the arrays
        Arrays.sort(arr);

        while (start < end) {
            currentSum = arr[start] + arr[end];
            System.out.println("prevSum:" + prevSum);
            System.out.println("currentSum:" + currentSum);

            if (start!=0 && end != arr.length-1 && Math.abs(target-currentSum) > Math.abs(target-prevSum)) {
                System.out.println("Closest match:" + prevSum);
                break;
            }

            if (currentSum < target) {
                start++;
            } else if (currentSum > target) {
                end--;
            } else {
                System.out.println("Exact match:" + currentSum);
                break;
            }
            prevSum = currentSum;
        }

        System.out.println("Closest match:" + currentSum);

    }
}
