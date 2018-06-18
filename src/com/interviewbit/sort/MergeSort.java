package com.interviewbit.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main (String args[]) {

//        int []arr = {2, -1, 1, -4};
        int []arr = {6, 5, 3, 1, 8, 7, 2, 4};

        if (arr.length > 1) {
            new MergeSort().func1(arr, 0, arr.length - 1);
        }

        System.out.println("Final Array: " + Arrays.toString(arr));
    }

    private void func1(int arr[], int start, int end) {
        int mid = start + (end - start/2);

        if (end - start < 2) {
            func2(arr, start, mid, end);
            return;
        }


        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("start: " + start);
        System.out.println("mid: " + mid);
        System.out.println("mid - start: " + (mid - start)/2);
        System.out.println("end - mid: " + (mid + 1 + (end - mid)/2));
        System.out.println("end: " + end);

        func1(arr, start, mid - 1); // first half
        func1(arr, mid, end); // second half
        func2(arr, start, mid, end);
    }

    // iteratively go over the array to merge
    private void func2(int arr[], int start, int mid, int end) {
        // copy array
//        int[] a = new int[arr.length];
//
//        for (int i=0; i <= end; i++) {
//            a[i] = arr[i];
//        }
//
//        // compare arrays
//        int x = start;
//        int y = mid;
//
//        for (int i=start; i <= end; i++) {
//            if (a[x] <= a[y]) {
//                arr[i] = a[x];
//                if (x < mid) {
//                    x++;
//                }
//            } else {
//                arr[i] = a[mid];
//                if (mid <y && y <= end) {
//                    y++;
//                }
//            }
//        }

        int[] a = new int[mid-start+1];
        int[] b = new int[end-mid+1];
        int x = 0;
        int y = 0;

        for(int i=start; i <= end; i++) {
            if (i < mid) {
                a[x] = arr[i];
                x++;
            } else {
                b[y] = arr[i];
                y++;
            }
        }

        System.out.println("yay!");

        // Merge
        x = y = 0;
        for(int i=start; i <=end; i++) {
            if (x >= a.length) {
                arr[i] = b[y];
            } else if (y >= b.length) {
                arr[i] = a[x];
            } else if(a[x] <= b[y]) {
                arr[i] = a[x];
                x++;
            } else if (a[x] > b[y]){
                arr[i] = b[y];
                y++;
            }

        }
    }
}
