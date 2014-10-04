package com.birin.sorting;

import com.birin.main.Utils;

public class BubbleSorter implements Sorter {

	@Override
	public void sort(int[] data) {
		final int dataLength = data.length;
		for (int pass = 0; pass < dataLength; pass++) {
			for (int index = 0; index < dataLength - pass - 1; index++) {
				if (data[index + 1] < data[index]) {
					int temp = data[index];
					data[index] = data[index + 1];
					data[index + 1] = temp;
				}
			}
		}
		Utils.printIntArray(data);
	}
}

// Compare two element at a time & move highest element at end so array gets
// sorted 1 by 1 from end.
