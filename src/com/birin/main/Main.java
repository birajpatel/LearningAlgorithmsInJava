package com.birin.main;

import com.birin.datastructures.linkedlists.CircularLinkedList;

public class Main {

	public static void main(String[] args) {
		int[] data = Utils.getFixData();
		new CircularLinkedList().main(data);
	}
}
