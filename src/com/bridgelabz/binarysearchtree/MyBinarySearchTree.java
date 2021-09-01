package com.bridgelabz.binarysearchtree;

public class MyBinarySearchTree<K extends Comparable<K>> {
	private MyBinaryNode<K> root;

	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}

	private MyBinaryNode<K> addRecursively(MyBinaryNode<K> currentNode, K key) {
		if (currentNode == null) {
			return new MyBinaryNode<>(key);
		}
		int compareResult = key.compareTo(currentNode.key);
		if (compareResult == 0)
			return currentNode;
		if (compareResult < 0) {
			currentNode.left = addRecursively(currentNode.left, key);
		} else {
			currentNode.right = addRecursively(currentNode.right, key);
		}
		return currentNode;
	}

	public int getSize() {
		return getSizeRecursively(root);
	}

	private int getSizeRecursively(MyBinaryNode<K> current) {
		return (current == null) ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
	}

}
