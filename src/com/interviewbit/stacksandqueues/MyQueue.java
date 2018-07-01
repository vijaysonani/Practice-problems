package com.interviewbit.stacksandqueues;

import java.util.ArrayList;

public class MyQueue<E> {
    private ArrayList<E> queue;

    MyQueue() {queue = new ArrayList<>();}

    protected void add(E val) {
        queue.add(val);
    }

    protected E remove() {
        if (queue.size() > 0) {
            return queue.remove(0);
        }
        return null;
    }

    protected boolean isEmpty() {
        return queue.size() == 0;
    }

    protected E peek() {
        if (queue.size() > 0) {
            return queue.get(0);
        }
        return null;
    }
}
