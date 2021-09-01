package com.bridgelabz.binarysearchtree;

public class BinarySearchTreeMain {
	public static void main(String[] args) {
		MyBinarySearchTree<Integer> myBinarySearchTree = new MyBinarySearchTree<Integer>();
		int [] array= {56, 30, 22, 11, 3, 16, 40, 70, 60, 95, 65, 63, 67};
		for(int eachElement:array) {
			myBinarySearchTree.add(eachElement);
		}
		int sizeOfTree = myBinarySearchTree.getSize();
		System.out.println("Size of the Binary search tree is: " + sizeOfTree);

	}
}
