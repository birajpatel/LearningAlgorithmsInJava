package com.birin.sorting;

public class HeapSorter implements Sorter {

	private static final int HEAP_ROOT = 0;

	@Override
	public void sort(int[] data) {
		createHeap(data);
		sortHeap(data);
	}

	private final int getParentIndex(int childIndex) {
		if (childIndex > HEAP_ROOT) {
			return (int) Math.floor((childIndex - 1) / 2);
		} else {
			return Integer.MIN_VALUE;
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return (2 * parentIndex + 1);
	}

	private int getRightChildIndex(int parentIndex) {
		return (2 * parentIndex + 2);
	}

	private boolean swapIfparentLowerThanChild(int[] data, int parent, int child) {
		int dataAtParent = data[parent];
		int dataAtChild = data[child];
		if (dataAtParent < dataAtChild) {
			data[parent] = dataAtChild;
			data[child] = dataAtParent;
			return true;
		}
		return false;
	}

	/**
	 * Start looking data from position 1 check if its position is correct in
	 * structure by checking all the parents up-to zero, stop checking if
	 * already smaller than any parent so for example checking for index=6 then
	 * compare data at index = 6 & its parent index = 2, once checked compare
	 * index = 2 & index = 0 & stop so cycle of 6 is complete.
	 * 
	 */
	private void createHeap(int[] data) {
		for (int i = 1; i < data.length; i++) {
			int child = i;
			int parent;
			boolean swapped;
			do {
				parent = getParentIndex(child);
				swapped = swapIfparentLowerThanChild(data, parent, child);
				child = parent;
			} while (child != HEAP_ROOT && swapped);
		}
	}

	private void sortHeap(int[] data) {
		int size = data.length;
		for (int i = size - 1; i >= 1; i--) {
			int child = i;
			int parent = 0;
			// Swap ROOT & last unsorted child, after swapping re-correct heap
			// structure because, highest element may not be present
			// at ROOT after swap
			swap(data, parent, child);

			boolean swappedLeft;
			boolean swappedRight;
			do {
				// start looking from top ROOT for new ROOT's correct new
				// position.
				int left = getLeftChildIndex(parent);
				int right = getRightChildIndex(parent);
				int leftData = 0;
				if (left < size) {
					leftData = data[left];
				}
				int rightData = 0;
				if (right < size) {
					rightData = data[right];
				}
				if (right >= i || leftData >= rightData) {
					// Swap left side if left data is greater or equal to right
					// or
					// right index has already crossed sorted mark (value of i
					// denotes sorted data start limit.)
					if (left >= i) {
						// Also if left has also already crossed sorted mark
						// then avoid swap.
						swappedLeft = false;
					} else {
						swappedLeft = swapIfparentLowerThanChild(data, parent,
								left);
						// Assign new parent as left child since was swapped
						// with left child.
						parent = left;
					}
					swappedRight = false;
				} else {
					swappedLeft = false;
					swappedRight = swapIfparentLowerThanChild(data, parent,
							right);
					// Assign new parent as right child since was swapped
					// with right child.
					parent = right;
				}
			} while (swappedLeft || swappedRight);
		}
	}

	private static void swap(int[] data, int parentIndex, int childIndex) {
		int temp = data[parentIndex];
		data[parentIndex] = data[childIndex];
		data[childIndex] = temp;
	}
}
