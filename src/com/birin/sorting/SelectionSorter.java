package com.birin.sorting;

import com.birin.main.Utils;

public class SelectionSorter implements Sorter {

	@Override
	public void sort(int[] data) {
		final int dataLength = data.length;
		int smallestValueIndex = 0;
		for (int pass = 0; pass < dataLength - 1; pass++) {
			smallestValueIndex = pass;
			for (int index = pass + 1; index < dataLength; index++) {
				if (data[smallestValueIndex] > data[index]) {
					smallestValueIndex = index;
				}
			}
			if (pass != smallestValueIndex) {
				int temp = data[pass];
				data[pass] = data[smallestValueIndex];
				data[smallestValueIndex] = temp;
			}
		}
		Utils.printIntArray(data);
	}

}

// start looking for numbers from index+1 to end & if smaller element is found
// then index value is assigned to it till the time array is sorted. array gets
// sorted from beginning.