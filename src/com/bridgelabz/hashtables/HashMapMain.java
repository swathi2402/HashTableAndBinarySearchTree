package com.bridgelabz.hashtables;

public class HashMapMain {

	public static void main(String[] args) {
		String sentence = "Paranoid are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		MyLinkedHshMap<String, Integer> myLinkedHshMap = new MyLinkedHshMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHshMap.get(word);
			if (value == null) {
				value = 1;
			} else {
				value += 1;
			}
			myLinkedHshMap.add(word, value);
		}
		myLinkedHshMap.remove("avoidable");
	}

}
