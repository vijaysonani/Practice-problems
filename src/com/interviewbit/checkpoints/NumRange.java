package com.interviewbit.checkpoints;

import java.util.ArrayList;

/**
 * Given an array of non negative integers A, and a range (B, C),
 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
 *
 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 * where 0 <= i <= j < size(A)
 *
 * Example :
 *
 * A : [10, 5, 1, 0, 2]
 * (B, C) : (6, 8)
 * ans = 3
 * as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]
 *
 *  NOTE : The answer is guaranteed to fit in a 32 bit signed integer.
 */

public class NumRange {
    public static void main (String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int B, C;

//        B = 6;
//        C = 8;
//
//        list.add(10);
//        list.add(5);
//        list.add(1);
//        list.add(0);
//        list.add(2);

//        A : [ 1 ]
//        B : 0
//        C : 0
//        B = 0;
//        C = 0;
//        list.add(1);


//        [2, 5, 1, 1, 2, 2, 3, 4, 8, 2] with [lo, hi] = [3, 6]:
        B = 3;
        C = 6;

        list.add(2);
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(8);
        list.add(2);

        new NumRange().numRange(list, B, C);
    }

    public int numRange(ArrayList<Integer> A, int B, int C) {
        int sum = 0;
        int cnt = 0;
        int bluePointer; // slow pointer
        int redPointer = 0;  // fast pointer

        bluePointer = 0;

        while (bluePointer < A.size()) {
            if (redPointer < A.size() - 1) {
                redPointer++;
            }

            if (A.size() < 2) {
                sum = A.get(bluePointer);
            } else if (sum == 0) { // new sum
                if (redPointer < A.size()) {
                    sum = A.get(bluePointer) + A.get(redPointer);
                }
            } else { // current sequence
                if (redPointer < A.size()) {
                    sum += A.get(redPointer);
                } else {
                    sum = 0;
                }
            }

            if (sum >= B && sum <= C) { // if sum is in range, just increment redPointer
                cnt++;
            } else if (sum > C) {
                bluePointer++;
                redPointer = bluePointer;
                sum = 0;
            }
        }

        return cnt;
    }
}
