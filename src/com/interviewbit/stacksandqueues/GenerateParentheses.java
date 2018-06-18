package com.interviewbit.stacksandqueues;

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
