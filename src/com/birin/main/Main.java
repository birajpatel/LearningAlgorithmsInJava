package com.birin.main;

import com.birin.datastructures.linkedlists.SinglyLinkedList;

public class Main {

	public static void main(String[] args) {
		int[] data = Utils.getFixData();
		new SinglyLinkedList().main(data);
	}
}
