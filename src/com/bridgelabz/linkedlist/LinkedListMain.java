package com.bridgelabz.linkedlist;

public class LinkedListMain {
	public static void main(String[] args) {
		MyNode<Integer> firstNode = new MyNode<>(56);
		MyNode<Integer> secondNode = new MyNode<>(30);
		MyNode<Integer> thirdNode = new MyNode<>(40);
		MyNode<Integer> fourthNode = new MyNode<>(70);
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.orderedListAdd(firstNode);
		myLinkedList.orderedListAdd(secondNode);
		myLinkedList.orderedListAdd(thirdNode);
		myLinkedList.orderedListAdd(fourthNode);
		myLinkedList.printMyNodes();
	}
}
