package com.interviewbit.strings;

/**
 *
 * You are given a string. The only operation allowed is to insert characters in
 * the beginning of the string. How many minimum characters are needed to be
 * inserted to make the string a palindrome string
 *
 * Example: 
 *
 * Input: ABC 
 * Output: 2
 *
 * Input: AACECAAAA 
 * Output: 2
 *
 * Ask interviewer: case sensitivity
 *
 */

public class AppendStringPalindrome {
  public static void main(String args[]) {
    System.out.println("AppendStringPalindrome");
    // System.out.println(new AppendStringPalindrome().convert("ABC"));
    // System.out.println(new AppendStringPalindrome().convert("AACECAAAA"));
    // System.out.println(new AppendStringPalindrome().convert("hqghumeaylnlfdxfi"));    
    // System.out.println(new AppendStringPalindrome().convert("babb"));        
    System.out.println(new AppendStringPalindrome().convert("eylfpbnpljvrvipyamyehwqnq"));
  }

  public int convert(String A) {
    int result = 0;
    int startPtr = 0;
    int lastMatchPtr = 0;
    int endPtr = A.length() - 1;
    A = A.toUpperCase();

    while (startPtr < endPtr) {
      if (A.charAt(startPtr) != A.charAt(endPtr)) {
        if (startPtr != lastMatchPtr) {
          result += lastMatchPtr + 1;
          startPtr = 0;
          lastMatchPtr = 0;
        } else {
          result++;
          endPtr--;
        }
      } else {
        lastMatchPtr = startPtr;
        startPtr++;
        endPtr--;
      }
    }

    return result;
  }
}
