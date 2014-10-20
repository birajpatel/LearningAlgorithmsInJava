package com.birin.main;

import com.birin.sorting.HeapSorter;

public class Main {

	public static void main(String[] args) {
		int[] data = Utils.getHugeRandomData();
		new HeapSorter().sort(data);
		System.out.println("Done");
		Utils.printIntArray(data);
	}
}
