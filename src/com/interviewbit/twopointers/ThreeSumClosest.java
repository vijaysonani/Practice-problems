package com.interviewbit.twopointers;

import java.util.*;

public class ThreeSumClosest {

    public static void main (String args[]) {
        ArrayList<Integer> list = new ArrayList<>();

        // {-1, 2, 1, -4};
//        final int target = 1;
//        list.add(-1);
//        list.add(2);
//        list.add(1);
//        list.add(-4);


//        A : [ 7, 2, -5, 10, -3, 4, 9, 1, -6, -10 ]
//        B : 2
//        final int target = 2;
//        list.add(7);
//        list.add(2);
//        list.add(-5);
//        list.add(10);
//        list.add(-3);
//        list.add(4);
//        list.add(9);
//        list.add(1);
//        list.add(-6);
//        list.add(-10);

//        A : [ -10, -10, -10 ]
//        B : -5
//        final int target = -5;
//        list.add(-10);
//        list.add(-10);
//        list.add(-10);

//        A : [ 10, -6, 3, 4, -8, -5 ]
//        B : 3
//        final int target = 3;
//        list.add(10);
//        list.add(-6);
//        list.add(3);
//        list.add(4);
//        list.add(-8);
//        list.add(-5);

//        A : [ -4, -8, -10, -9, -1, 1, -2, 0, -8, -2 ]
//        B : 0
        final int target = 3;
        list.add(-4);
        list.add(-8);
        list.add(-10);
        list.add(-9);
        list.add(-1);
        list.add(1);
        list.add(-2);
        list.add(0);
        list.add(-8);
        list.add(-2);

        new ThreeSumClosest().threeSumClosest(list, target);
    }

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int first = 0;
        int second = 1;
        int third = A.size() -1;
        int currentSum;

        if (A.size() == 3) {
            return A.get(first) + A.get(second) + A.get(third);
        } else if (A.size() < 3) {
            return -1; // invalid
        }

        A.sort(Comparator.comparing(Integer::byteValue));
        int prevSum = A.get(first) + A.get(second) + A.get(third);

        for (int i=0 ; i < third -1; i++) {
            second = i + 1;
            third = A.size() - 1;

            while (second < third) {
                currentSum = A.get(i) + A.get(second) + A.get(third);

                if (Math.abs(B - currentSum) < Math.abs(B - prevSum)) {
                    prevSum = currentSum;
                } else {
                    continue;
                }

//                if (Math.abs(target-currentSum) > Math.abs(target-prevSum)) {
//                    System.out.println("Closest match:" + prevSum);
//                    break;
//                }

                if (currentSum < B) {
                    second++;
                } else if (currentSum > B) {
                    third--;
                } else {
                    prevSum = currentSum;
                    break;
                }
            }


        }

        System.out.println(prevSum);
        return prevSum;
    }
}
