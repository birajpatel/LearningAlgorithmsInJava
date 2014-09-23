package com.birin.sorting;

import com.birin.main.Utils;

public class SmartBubbleSorter implements Sorter {

	@Override
	public void sort(int[] data) {
		final int dataLength = data.length;
		boolean unsorted = true;
		for (int pass = 0; pass < dataLength && unsorted; pass++) {
			unsorted = false;
			for (int index = 0; index < dataLength - pass - 1; index++) {
				if (data[index + 1] < data[index]) {
					unsorted = true;
					int temp = data[index];
					data[index] = data[index + 1];
					data[index + 1] = temp;
				}
			}
		}
		Utils.printIntArray(data);
	}
}
