package com.birin.main;

import java.util.Random;

public class Utils {

	private static Random random;

	static {
		random = new Random();
	}

	public static final void printIntArray(int[] array) {
		for (int element : array) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static final int[] getRandomData() {
		return generateData(10);
	}

	public static final int[] getHugeRandomData() {
		return generateData(30);
	}

	private static int[] generateData(int requiredSize) {
		int size = random.nextInt(requiredSize);
		if (size == 0) {
			size = 5; // fall through
		}
		int[] randomData = new int[size];
		for (int i = 0; i < size; i++) {
			randomData[i] = getRandomInt();
		}
		printIntArray(randomData);
		return randomData;
	}

	public static final int[] getFixData() {
		final int[] FIX = new int[] { 62, 52, 82, 94, 93 };
		System.out.print("FIX Input: ");
		printIntArray(FIX);
		return FIX;
	}

	public static final int getRandomInt() {
		return random.nextInt(100);
	}

}
