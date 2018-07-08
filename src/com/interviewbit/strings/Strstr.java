package com.interviewbit.strings;

/**
 *
 * Please Note:
 * Another question which belongs to the category of questions which are intentionally stated vaguely.
 * Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.
 *
 * Implement strStr().
 *
 *  strstr - locate a substring ( needle ) in a string ( haystack ).
 * Try not to use standard library string functions for this question.
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * NOTE: Good clarification questions:
 * What should be the return value if the needle is empty?
 * What if both haystack and needle are empty?
 * For the purpose of this problem, assume that the return value should be -1 in both cases.
 *
 */

public class Strstr {
    public static void main(String args[]) {
        System.out.println("Strstr");
//        System.out.println(new Strstr().strStr("String", "rin"));

//        A : "bbbbbbbbab "
//        B : "baba"
//        Expected: -1
//        System.out.println(new Strstr().strStr("bbbbbbbbab", "baba"));

//        A : "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba "
//        B : "babaaa"
//        Expected: 48

        System.out.println(new Strstr().strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
    }

    public static int strStr(final String A, final String B) {
        if (B.isEmpty() || A.isEmpty()) { return -1; }

        int result = -1;
        char cHay;
        char cNeed = B.charAt(0);

        for (int i =0; i < A.length(); i++) {
            cHay = A.charAt(i);

            if (cHay == cNeed) {
                result = i;

                if (isSubString(A, B, i)) {
                    break;
                }
            }

            result = -1;
        }

        return result;
    }

    // Verify substring
    private static boolean isSubString (final String A, final String B, final int index) {
        if (B.length() + index > A.length()) { return false; }

        for (int i = 0; i < B.length(); i++) {
            if (A.charAt(index + i) != B.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
