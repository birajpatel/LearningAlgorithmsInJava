package com.birin.main;

import com.birin.search.BinarySearcher;

public class Main {

	public static void main(String[] args) {
		int searchKey = Utils.getRandomInt();
		System.out.println("Searching for : " + searchKey);
		int[] input = Utils.getHugeRandomData();
		BinarySearcher searcher = new BinarySearcher();
		System.out.println("Present at : " + searcher.search(input, searchKey));
	}
}
