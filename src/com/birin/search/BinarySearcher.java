package com.birin.search;

import com.birin.sorting.MergeSorter;
import com.birin.sorting.Sorter;

public class BinarySearcher implements Searcher {

	@Override
	public int search(int[] input, int searchKey) {
		sortData(input);
		return searchSortedData(input, 0, input.length - 1, searchKey);
	}

	private void sortData(int[] input) {
		Sorter sorter = new MergeSorter();
		sorter.sort(input);
	}

	private int searchSortedData(int[] input, int low, int high, int searchKey) {
		if (high < low) {
			return -1;
		}
		final int mid = (low + high) / 2;
		final int dataAtMid = input[mid];
		if (searchKey == dataAtMid) {
			return mid;
		} else if (searchKey < dataAtMid) {
			return searchSortedData(input, low, mid - 1, searchKey);
		} else {
			return searchSortedData(input, mid + 1, high, searchKey);
		}

	}
}

// Narrow down search by dividing problems in Half.