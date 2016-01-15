package com.chepeatio;

import com.chepeatio.convertSortedListToBinarySearchTree.ConvertSortedListToBinarySearchTree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, LeetCode!");
        ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
        test.displayTree(test.sortedListToBST(test.getListHead()));
    }
}
