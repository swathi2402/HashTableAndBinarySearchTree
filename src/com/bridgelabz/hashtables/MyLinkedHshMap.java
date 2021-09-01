package com.bridgelabz.hashtables;

import java.util.ArrayList;

import com.bridgelabz.linkedlist.INode;
import com.bridgelabz.linkedlist.MyLinkedList;

public class MyLinkedHshMap<K, V> {

	private final int numberOfBuckets;
	ArrayList<MyLinkedList<K>> myBucketArray;

	public MyLinkedHshMap() {
		this.numberOfBuckets = 9;
		this.myBucketArray = new ArrayList<>(numberOfBuckets);
		for (int index = 0; index < numberOfBuckets; index++) {
			this.myBucketArray.add(null);
		}
	}

	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numberOfBuckets;
		return index;
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			return null;
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if (myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.myBucketArray.set(index, myLinkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<K, V>(key, value);
			myLinkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	public void remove(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
		if(myLinkedList==null) {
			System.out.println("The word " + key + " is not present");
			return;
		}
		myLinkedList.head = null;		
	}

	@Override
	public String toString() {
		return "MyLinkedHashMap { " + myBucketArray + " } ";
	}
}
