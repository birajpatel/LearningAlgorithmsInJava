package com.birin.main;

import com.birin.datastructures.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		int[] data = Utils.getFixData();
		new BinarySearchTree().main(data);
	}
}
