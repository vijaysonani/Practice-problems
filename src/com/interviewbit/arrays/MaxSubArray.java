package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example:
 *
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 *
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * For this problem, return the maximum sum.
 */

public class MaxSubArray {
    public static void main (String args[]) {
        System.out.println("MaxSubArray");
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(1);
        list.add(-3);
        list.add(4);
        list.add(-1);
        list.add(2);
        list.add(1);
        list.add(-5);
        list.add(4);

//        list.add(-500);

        System.out.println(new MaxSubArray().maxSubArray(list));
    }

    public int maxSubArray(final List<Integer> A) {
        int result = A.get(0);
        int[] sum = new int[A.size()];
        sum[0] = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            sum[i] = Math.max(A.get(i), sum[i - 1] + A.get(i));
            result = Math.max(result, sum[i]);
        }

        return result;
    }
}
