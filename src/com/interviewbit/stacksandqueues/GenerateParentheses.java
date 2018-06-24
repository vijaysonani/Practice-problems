package com.interviewbit.stacksandqueues;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class GenerateParentheses extends MyStack {
    public static void main (String args[]) {
        String inputString = "(){}[]";

        System.out.println(new GenerateParentheses().isValid(inputString));
    }

    public int isValid(String A) {
        MyStack<Character> stack = new MyStack<>();
        char c;

        for (int i=0; i < A.length(); i++) {
            c = A.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }

                char top = stack.peek();
                if (top == '(' && c == ')'|| top == '[' && c == ']' || top == '{' && c == '}') {
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}
