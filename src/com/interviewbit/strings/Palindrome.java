package com.interviewbit.strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example:
 *
 * "A man, a plan, a canal: Panama" is a palindrome.
 *
 * "race a car" is not a palindrome.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class Palindrome {
    public static void main(String args[]) {
        System.out.println("Palindrome");
        System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));  // Is Palindrome
//        System.out.println(new Palindrome().isPalindrome("race a car"));  // Not a palindrome
    }
    public int isPalindrome(String A) {
        String sanitizedString = A.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int start = 0;
        int end = sanitizedString.length() -1;

        while (start < end) {
            if (sanitizedString.charAt(start) != sanitizedString.charAt(end)) {
                return 0;
            } else {
                start++;
                end--;
            }

        }
        return 1;
    }
}
