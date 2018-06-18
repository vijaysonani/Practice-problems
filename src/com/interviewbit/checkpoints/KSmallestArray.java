package com.interviewbit.checkpoints;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KSmallestArray {
    public static void main (String args[]) {
        List<Integer> list1 = new ArrayList<>();
//        int k = 3;
//
//        list1.add(2);
//        list1.add(1);
//        list1.add(4);
//        list1.add(3);
//        list1.add(2);


//        A : [ 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 ]
//        B : 9
//        int k = 3;
//        list1.add(8);
//        list1.add(16);
//        list1.add(80);
//        list1.add(55);
//        list1.add(32);
//        list1.add(8);
//        list1.add(38);
//        list1.add(40);
//        list1.add(65);
//        list1.add(18);
//
//        list1.add(15);
//        list1.add(45);
//        list1.add(50);
//        list1.add(38);
//        list1.add(54);
//        list1.add(52);
//        list1.add(23);
//        list1.add(74);
//        list1.add(81);
//        list1.add(42);
//
//        list1.add(28);
//        list1.add(16);
//        list1.add(66);
//        list1.add(35);
//        list1.add(91);
//        list1.add(9);
//        list1.add(36);
//        list1.add(44);
//        list1.add(85);
//        list1.add(58);
//
//        list1.add(59);
//        list1.add(49);
//        list1.add(75);
//        list1.add(20);
//        list1.add(87);
//        list1.add(60);
//        list1.add(17);
//        list1.add(11);
//        list1.add(39);
//        list1.add(62);
//        list1.add(20);
//        list1.add(17);
//        list1.add(46);
//        list1.add(26);
//        list1.add(81);
//        list1.add(92);

//        A : [ 74, 90, 85, 58, 69, 77, 90, 85, 18, 36 ]
//        B : 1
        int k = 1;

        list1.add(74);
        list1.add(90);
        list1.add(85);
        list1.add(58);
        list1.add(69);
        list1.add(77);
        list1.add(90);
        list1.add(85);
        list1.add(18);
        list1.add(36);

        new KSmallestArray().kthsmallest(list1, k);
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        int j;
        int cntLess;
        int cntMore;

        List<Integer> newList = new ArrayList<>();

        for (Integer i : A) {
            newList.add(i);
        }
        newList.sort(Comparator.comparing(Integer::intValue));

        for(int i = 0; i < A.size(); i++) {
            cntLess = 0;
            cntMore = 0;
            j= 0;

            while(j < A.size()) {
                if (A.get(j) < A.get(i)) {
                    cntLess++;
                } else if (A.get(j) > A.get(i)) {
                    cntMore++;
                }
                j++;
            }

            if (cntLess < B && B <= (A.size() - cntMore)) {
                 System.out.println(A.get(i));
                return A.get(i);
            }
        }

        System.out.println("Error");
        return -1;
    }
}
