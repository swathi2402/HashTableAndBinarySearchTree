package com.bridgelabz.linkedlist;

public class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;

	public MyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
	}

	public void add(INode<K> newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} else {
			INode<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}

	public void append(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}

	public void insert(INode<K> myNode, INode<K> newNode) {
		INode<K> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	public INode<K> popLast() {
		INode<K> tempNode = this.head;
		while (!tempNode.getNext().equals(this.tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tempNode = tempNode.getNext();
		this.tail.setNext(null);
		return tempNode;
	}

	public INode<K> search(K key) {
		INode<K> tempNode = this.head;
		while (tempNode != null && tempNode.getNext() != null) {
			System.out.println(tempNode.getKey().equals(key) + " " + key);
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		if (tempNode != null && tempNode.getNext() == null) {			
			return tempNode;
		}
		return null;
	}

	public void insertAtRandom(INode<K> keyNode, INode<K> newNode) {
		INode<K> tempNode = this.head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(keyNode.getKey())) {
				INode<K> nextNode = tempNode.getNext();
				tempNode.setNext(newNode);
				tempNode = tempNode.getNext();
				tempNode.setNext(nextNode);
			}
			tempNode = tempNode.getNext();
		}
	}

	public void deleteAtRandom(INode<K> keyNode) {
		INode<K> tempNode = this.head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (!tempNode.getKey().equals(keyNode.getKey())) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(tempNode.getNext().getNext());
			break;
		}
		if (tempNode != null && tempNode.getNext() == null) {
			tempNode = tempNode.getNext();
		}
	}

	public void orderedListAdd(INode<K> newNode) {

		if (this.head == null || (int) head.getKey() > (int) newNode.getKey()) {
			newNode.setNext(head);
			head = newNode;
		} else {
			INode<K> currentNode = this.head;

			boolean isInserted = false;
			while (currentNode.getNext() != null) {
				if ((int) currentNode.getNext().getKey() > (int) newNode.getKey()) {
					newNode.setNext(currentNode.getNext());
					currentNode.setNext(newNode);
					isInserted = true;
					break;
				} else {
					currentNode = currentNode.getNext();
				}
			}
			if (!isInserted) {
				currentNode.setNext(newNode);
			}
		}
	}

	public int size() {
		int count = 0;
		INode<K> tempNode = this.head;
		while (tempNode != null) {
			count++;
			tempNode = tempNode.getNext();
		}
		return count;
	}

	public void printMyNodes() {
		StringBuffer printNodes = new StringBuffer("My Nodes: ");
		INode<K> tempNode = this.head;
		while (tempNode.getNext() != null) {
			printNodes.append(tempNode.getKey());
			if (!tempNode.equals(this.tail))
				printNodes.append(" -> ");
			tempNode = tempNode.getNext();
		}
		printNodes.append(tempNode.getKey());
		System.out.println(printNodes);
	}

	@Override
	public String toString() {
		return "MyLinkedListNodes { " + head + " } ";
	}
}
