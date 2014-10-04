package com.birin.sorting;

import com.birin.main.Utils;

public class InsertionSort implements Sorter {

	@Override
	public void sort(int[] data) {
		final int dataLength = data.length;
		for (int pass = 1; pass < dataLength; pass++) {
			for (int index = pass; index > 0; index--) {
				if (data[index - 1] > data[index]) {
					int temp = data[index];
					data[index] = data[index - 1];
					data[index - 1] = temp;
				} else {
					break;
				}
			}
		}
		Utils.printIntArray(data);
	}
}

// Inserting smallest element at its correct position, so it sorts from
// beginning, starting from 1st index look for its correct position by looking
// data from index-1 to 0, break once not possible to swap as previous entries
// are already sorted.
