package com.chepeatio.peekingIterator;

import java.util.*;

/**
 * Created by Che Peatio on 2015/12/22.
 */
public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int temp;
    boolean hasNext;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            hasNext = true;
            temp = this.iterator.next();
        } else {
            hasNext = false;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return temp;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = temp;
        if (this.iterator.hasNext()) {
            hasNext = true;
            temp = this.iterator.next();
        } else {
            hasNext = false;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}
