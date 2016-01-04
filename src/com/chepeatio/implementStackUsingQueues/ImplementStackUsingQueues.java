package com.chepeatio.implementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Che Peatio on 2016/1/4.
 */
public class ImplementStackUsingQueues {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    boolean state = false; // false means preOperation is queue1, true means preOperation is queue2

    // Push element x onto stack.
    public void push(int x) {
        if (state) {
            queue1.clear();
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
            state = false;
        } else {
            queue2.clear();
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
            state = true;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (state) {
            queue2.remove();
        } else {
            queue1.remove();
        }
    }

    // Get the top element.
    public int top() {
        if (state)
            return queue2.peek();
        else
            return queue1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return state ? queue2.isEmpty() : queue1.isEmpty();
    }
}
