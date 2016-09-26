package com.chepeatio.implementQueueUsingStacks;

import java.util.Stack;

/**
 * Created by Che Peatio on 2015/12/1.
 */
public class ImplementQueueUsingStacks {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    boolean state = false; // false means preOperation is in, true means preOperation is out.

    // Push element x to the back of queue.
    public void push(int x) {
        if (!state) {
            in.push(x);
        } else {
            in.clear();
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            in.push(x);
            state = false;
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!state) {
            out.clear();
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            out.pop();
            state = true;
        } else {
            out.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if (!state) {
            out.clear();
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            state = true;
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (!state) ? in.isEmpty() : out.isEmpty();
    }
}
