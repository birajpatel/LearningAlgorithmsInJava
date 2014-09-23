package com.birin.main;

import java.util.Random;

public class Utils {

	private static Random random;

	static {
		random = new Random();
	}

	public static final void printIntArray(int[] array) {
		for (int element : array) {
			System.out.print(element+" ");
		}
		System.out.println();
	}

	public static final int[] getRandomData() {
		int size = random.nextInt(10);
		if (size == 0) {
			size = 5; // fall through
		}
		int[] randomData = new int[size];
		for (int i = 0; i < size; i++) {
			randomData[i] = random.nextInt(100);
		}
		printIntArray(randomData);
		return randomData;
	}

}
