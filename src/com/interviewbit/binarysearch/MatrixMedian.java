package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.
 *
 * For example,
 *
 * Matrix=
 * [1, 3, 5]
 * [2, 6, 9]
 * [3, 6, 9]
 *
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 *
 * Median is 5. So, we return 5.
 * Note: No extra memory is allowed.
 */

public class MatrixMedian {
    public static void main (String args[]) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        list1.add(1);
        list1.add(3);
        list1.add(5);

        list2.add(2);
        list2.add(6);
        list2.add(9);

        list3.add(3);
        list3.add(6);
        list3.add(9);

        matrix.add(list1);
        matrix.add(list2);
        matrix.add(list3);
//
//        A :
//        [
//          [1, 1, 3, 3, 3, 3, 3]
//        ]
//        B: 3
//        list1.add(1);
//        list1.add(1);
//        list1.add(3);
//        list1.add(3);
//        list1.add(3);
//        list1.add(3);
//        list1.add(3);
//
//        matrix.add(list1);
//
//
//        A :
//        [
//          [39, 39, 39, 6292, 6292, 6292, 6292, 7002, 7002, 7002, 7002]
//        ]
//        B: 6292
//        list1.add(39);
//        list1.add(39);
//        list1.add(39);
//        list1.add(6292);
//        list1.add(6292);
//        list1.add(6292);
//        list1.add(6292);
//        list1.add(7002);
//        list1.add(7002);
//        list1.add(7002);
//        list1.add(7002);
//
//        matrix.add(list1);

        new MatrixMedian().findMedian(matrix);
    }

    // With extra memory
//    public int findMedian(ArrayList<ArrayList<Integer>> A) {
//
//        ArrayList<Integer> combinedArrayList = new ArrayList<>();
//
//        for (ArrayList<Integer> row : A) {
//            combinedArrayList.addAll(row);
//        }
//
//        combinedArrayList.sort(Comparator.comparing(Integer::intValue));
//
//        for (int i : combinedArrayList) {
//            System.out.println(i);
//        }
//
//        System.out.println("Final:");
//        System.out.println(combinedArrayList.size()/2);
//        System.out.println(combinedArrayList.get(combinedArrayList.size()/2));
//        return combinedArrayList.get(combinedArrayList.size()/2);
//    }

//    We cannot use extra memory, so we can’t actually store all elements in an array and sort the array.
//    But since, rows are sorted it must be of some use, right?
//
//    Note that in a row you can binary search to find how many elements are smaller than a value X in O(log M).
//    This is the base of our solution.
//
//            Say k = N*M/2. We need to find (k + 1)^th smallest element.
//    We can use binary search on answer. In O(N log M), we can count how many elements are smaller than X in the matrix.
//
//    So, we use binary search on interval [1, INT_MAX]. So, total complexity is O(30 * N log M).
//
//    Note:
//    This problem can be solve by using min-heap, but extra memory is not allowed.
//
    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        if(A == null || A.size() == 0)
            return 0;

        int row = A.size();
        int col = A.get(0).size();

        int cntSmaller = 0, cntRequired = (row * col) / 2;

        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = 0;
        boolean fnd = false;
        int pos = 0,ans = 0;

        while(low <= high)
        {
            mid = (low + high) / 2;
            fnd = false;
            cntSmaller = 0;

            for(int i = 0; i < row; i++)
            {
                pos = binarySearch(A.get(i),mid);
                // if(mid < 10)
                //     System.out.println(mid + " " + pos);
                cntSmaller += pos;
                // if(A.get(i).get(pos) == mid)
                //     fnd = true;
            }

            if(cntSmaller < cntRequired + 1)
                low = mid + 1;
            else
            {
                ans = mid;
                high = mid - 1;
            }
        }

        System.out.println("Final: " + ans);
        return ans;
    }

    /**
     *
     * First we find the minimum and maximum elements in the matrix. Minimum element can be easily found by comparing the first element of each row,
     * and similarly the maximum element can be found by comparing the last element of each row.
     *
     * Then we use binary search on our range of numbers from minimum to maximum, we find the mid of the min and max, and get count of numbers less than our mid.
     * And accordingly change the min or max.
     *
     * For a number to be median, there should be (r*c)/2 numbers smaller than that number.
     * So for every number, we get the count of numbers less than that by using upper_bound() in each row of matrix,
     *      if it is less than the required count, the median must be greater than the selected number,
     *      else the median must be less than or equal to the selected number.
     */
    public int binarySearch(ArrayList<Integer> A, int n)
    {
        if(A == null)
            return -1;

        if(A.get(0) > n)
            return 0;

        int low,mid,high;

        low = 0;
        mid = 0;
        high = A.size() - 1;

        while(low <= high)
        {
            mid = (low + high) / 2;

            // if(A.get(mid) == n && (mid == A.size()-1 || A.get(mid+1) > A.get(mid)))
            //     return mid;
            // else
            if(A.get(mid) > n)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
