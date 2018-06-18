package com.interviewbit.stacksandqueues;

import java.util.ArrayList;

public class MyStack<E> {
    private ArrayList<E> stack;

    MyStack() {stack = new ArrayList<>();}

    protected void push(E val) {
        stack.add(val);
    }

    protected E pop() {
        return stack.remove(stack.size() - 1);
    }

    protected boolean isEmpty() {
        return stack.size() == 0;
    }

    protected E peek() {
        return stack.get(stack.size() - 1);
    }

}
