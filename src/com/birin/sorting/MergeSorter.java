package com.birin.sorting;

import com.birin.main.Utils;

public class MergeSorter implements Sorter {

	@Override
	public void sort(int[] data) {
		sortBetween(0, data.length - 1, data);
		Utils.printIntArray(data);
	}

	private void sortBetween(int low, int high, int[] data) {
		if (low < high) {
			int mid = (low + high) / 2;
			sortBetween(low, mid, data);
			sortBetween(mid + 1, high, data);
			merge(data, low, mid, high);
		}
	}

	private void merge(int[] data, int low, int mid, int high) {
		final int tempArraySize = (high - low + 1);
		int[] tempArray = new int[tempArraySize];
		int firstPointer = low;
		int secondPointer = mid + 1;
		for (int tempIndex = 0; tempIndex < tempArraySize; tempIndex++) {
			final int pickupIndex;
			boolean isFirstPointerExahausted = firstPointer > mid;
			boolean isSecondPointerExahausted = secondPointer > high;
			if (isSecondPointerExahausted == true
					|| (isFirstPointerExahausted == false && data[firstPointer] < data[secondPointer])) {
				pickupIndex = firstPointer;
				firstPointer++;
			} else {
				pickupIndex = secondPointer;
				secondPointer++;
			}
			tempArray[tempIndex] = data[pickupIndex];
		}
		System.arraycopy(tempArray, 0, data, low, tempArraySize);
	}
}

// 1.Divide the sorting into half till low < high. & call sorting recursively
// low-mid & mid-high
// 2. merge the sorted array from bottom taking smaller merging at a time, pick
// from 1st smaller array if second is exhausted or 1st has valid data,
// otherwise pick from second smaller array.