package com.birin.main;

import com.birin.sorting.SmartBubbleSorter;
import com.birin.sorting.Sorter;

public class Main {

	public static void main(String[] args) {
		Sorter sorter = new SmartBubbleSorter();
		sorter.sort(Utils.getRandomData());
	}

}
