package com.interviewbit.strings;

/**
 * Please Note:
 * There are certain questions where the interviewer would intentionally frame the question vague.
 * The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.
 *
 * Implement atoi to convert a string to an integer.
 *
 * Example :
 *
 * Input : "9 2704"
 * Output : 9
 * Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.
 *
 *  Questions:
 *  Q1. Does string contain whitespace characters before the number?
 *      A. Yes
 *  Q2. Can the string have garbage characters after the number?
 *      A. Yes. Ignore it.
 *  Q3. If no numeric character is found before encountering garbage characters, what should I do?
 *      A. Return 0.
 *  Q4. What if the integer overflows?
 *      A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 *
 * Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */

public class Atoi {
    public static void main(String args[]) {
        System.out.println("Atoi");
//        System.out.println(new Atoi().atoi("9 2704"));
        System.out.println(new Atoi().atoi("2704 9"));
    }

    public int atoi(String A) {
        char c;
        double result = 0;
        boolean reverse = false;
        boolean isConverting = false;

        for (int i =0; i < A.length(); i++) {
            c = A.charAt(i);

            if (c == '-' && !isConverting) {
                reverse = true;
                isConverting = true;
                continue;
            } else if (c == '+' && !isConverting) {
                reverse = false;
                isConverting = true;
                continue;
            }

            if (c == ' ' && !isConverting && !reverse) {
                continue;
            }

            if (c < '0' || c > '9') {
                break;
            }

            result = (result*10) + (c - '0');
            isConverting = true;
        }

        if (reverse) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }
}
