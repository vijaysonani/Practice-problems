package com.interviewbit.other.lotum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 We like to rely on more than just your resume to get an idea of your skills, so if you are interested in continuing with your application, please take a few moments to answer the following programming questions.


 We are most interested in clarity, maintainability, and knowledge of your language’s core libraries than brevity and clever tricks. You may use any programming language to answer the following:


 1. Write a function that prints the numbers from 1 to 100. But for multiples of three print "Foo" instead of the number and for the multiples of five print "Bar". For numbers which are multiples of both three and five print "FooBar".

 Example output:

 1 2 Foo 4 Bar Foo 7 8 Foo Bar 11 Foo 13 14 FooBar ...


 2. Write a function that counts the number of even numbers that appear in a range of integers 0..n, where n is supplied as the sole argument to your function.

 Example:

 even_integers(3)
 2


 3. Given the following pseudo code, determine the range of possible values for "a" in your language of choice:

 x = random_int(1,6)
 y = random_int(1,6)
 z = random_int(1,6)
 a = x + y + z


 4. Given:

 words = ['one', 'one', 'two', 'three', 'three', 'two']

 Remove the duplicates.


 5. Print to stdout the following output using only one loop:

 1 1 1 1 1
 2 2 2 2 2
 3 3 3 3 3
 4 4 4 4 4
 5 5 5 5 5


 6. Write a method that finds the largest sum of consecutive entries in an array given a group size. It should take an array and the interval size as inputs and should return both the largest sum and the index of the first entry in the group.

 For example, in the following Array [1,1,1,1,1,1,1,2] given a group size of 2 the result would be a maximum sum of 3 and a position of 6.
 */
public class Solution {
    public static void main(String args[]) {
        Solution sol = new Solution();
//        sol.printFooBar();
//        sol.printEvenCount(10);

//        String []s = {"one", "one", "two", "three", "three", "two"};
//        sol.removeDuplicatesArray(s);
//        sol.printMatrix(5);

        int []arr = new int[]{1,1,2,2,1,1,1,2};
        sol.getLargestSum(arr, 2);
    }

    /**
     * I've used Java for all solutions.
     */

    /**
     * Prints numbers for 1 to 100. For multiples of 3 prints "Foo", for multiples of 5 prints "Bar",
     * and for multiples of both 3 and 5 prints "FooBar"
     */
    public void printFooBar() {
        for (int i=1; i<101; i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                System.out.print("FooBar ");
            } else if (i % 5 == 0) {
                System.out.print("Bar ");
            } else if (i % 3 == 0) {
                System.out.print("Foo ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Prints even integer values between 0 to n
     * @param n The upper limit of number range. Must be non-negative integer value.
     */
    public void printEvenCount(int n) {
        int count = 0;

        if (n < 0) {
            System.out.print("Range should be non-negative integer value but got " + n);
            return;
        }
        for (int i=0; i<=n; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }

        System.out.print("Number of even integers between 0 to " + n + " is: " + count);
    }

    /**
     * 3. Assuming the method "random_int" returns integer values between (and including) 1 and 6,
     *    variable "a" can have values between (and including) 3 to 18.
     */

    /**
     * Removes duplicates from the provided array
     * @param dupArray The original string array that might have duplicates
     * @return String array with unique values
     */
    public String[] removeDuplicatesArray(String[] dupArray) {
        Set<String> uniqueSet = new HashSet<>();

        for (String str : dupArray) {
            uniqueSet.add(str);
        }

        return uniqueSet.toArray(new String[uniqueSet.size()]);
    }

    /**
     * Print matrix
     * @param m Size of the m * m matrix
     */
    public void printMatrix(int m) {
        int [][] array = new int[m+1][m];

        for (int i=1; i<=m; i++)
        {
            Arrays.fill(array[i], i);
            System.out.println(Arrays.toString(array[i]));
        }
    }

    /**
     *  6. Write a method that finds the largest sum of consecutive entries in an array given a group size.
     *  It should take an array and the interval size as inputs and should return both the largest sum and the index of the first entry in the group.
     *
     *  For example, in the following Array [1,1,1,1,1,1,1,2] given a group size of 2 the result would be a maximum sum of 3 and a position of 6.
     */
    class Result {
        private int maxSum;
        private int position;

        Result() {
            maxSum = 0;
            position = 0;
        }

        public void setMaxSum(int maxSum) {
            this.maxSum = maxSum;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getMaxSum() {
            return maxSum;
        }

        public int getPosition() {
            return position;
        }
    }

    public Result getLargestSum(int []arr, int interval) {
        Result result = new Result();
        int sum;

        for (int i=0; i<= arr.length - interval; i++) {
            sum = 0;
            for (int j = 0; j < interval; j++) {
                sum += arr[i+j];
            }

            if (sum > result.maxSum) {
                result.setMaxSum(sum);
                result.setPosition(i);
            }
        }

        return result;
    }
}
