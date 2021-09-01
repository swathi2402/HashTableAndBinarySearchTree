package com.bridgelabz.binarysearchtree;

public class BinarySearchTreeMain {
	public static void main(String[] args) {
		MyBinarySearchTree<Integer> myBinarySearchTree = new MyBinarySearchTree<Integer>();
		myBinarySearchTree.add(56);
		myBinarySearchTree.add(30);
		myBinarySearchTree.add(70);
		int sizeOfTree = myBinarySearchTree.getSize();
		System.out.println("Size of the Binary search tree is: " + sizeOfTree);

	}
}
