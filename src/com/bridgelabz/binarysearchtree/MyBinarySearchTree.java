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
	
	public void search(K key) {
		boolean isFound = this.searchRecursively(key, root);
		if(isFound) {
			System.out.println("The value " + key + " is present");
		}else {
			System.out.println("The value " + key + " is not present");
		}
	}
	
	private boolean searchRecursively(K key, MyBinaryNode<K> currentNode) {
		if (currentNode == null)
			return false;
		
		int compareResult = currentNode.key.compareTo(key);
		
		if (compareResult == 0)
			return true;
		else if (compareResult > 0) {
			return searchRecursively(key, currentNode.left);
		} else {
			return searchRecursively(key, currentNode.right);
		}

	}

	public int getSize() {
		return getSizeRecursively(root);
	}

	private int getSizeRecursively(MyBinaryNode<K> current) {
		return (current == null) ? 0
				: 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
	}
}
