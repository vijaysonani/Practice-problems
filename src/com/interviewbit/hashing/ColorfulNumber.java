package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * For Given Number N find if its COLORFUL number or not
 *
 * Return 0/1
 *
 * COLORFUL number:
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
 * Example:
 *
 * N = 23
 * 2 3 23
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6
 * this number is a COLORFUL number since product of every digit of a sub-sequence are different.
 *
 * Output : 1
 */
public class ColorfulNumber {
    public static void main(String args[]) {
//        System.out.println("ColorfulNumber");
        System.out.println(new ColorfulNumber().colorful(12345));
    }

    public int colorful(int A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set= new HashSet<Integer>();
        int B = A;

        while (A > 0) {
            B = A % 10;
            list.add(B);
            A = A /10;
            System.out.println("B:" + B);
            System.out.println("A:" + A);
        }

        Collections.reverse(list);
        int n = list.size();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= list.get(k);
                }

                if (set.contains(prod))
                    return 0;

                set.add(prod);
            }
        }

        return 1;
    }
}
