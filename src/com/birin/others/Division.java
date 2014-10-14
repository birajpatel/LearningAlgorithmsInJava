package com.birin.others;

public class Division {

	public int divideInLoop(int number, int divideBy) {
		int absNumber = Math.abs(number);
		int absDivideBy = Math.abs(divideBy);
		int result = 0;
		while (absNumber >= absDivideBy) {
			result++;
			absNumber = absNumber - absDivideBy;
		}
		return (number > 0 && divideBy > 0 || number < 0 && divideBy < 0) ? result
				: -result;
	}

	public int divideWithRecursion(int number, int divideBy) {
		int absNumber = Math.abs(number);
		int absDivideBy = Math.abs(divideBy);
		int result = result(absNumber, absDivideBy, 0);
		return (number > 0 && divideBy > 0 || number < 0 && divideBy < 0) ? result
				: -result;
	}

	private int result(int number, int divideBy, int result) {
		if (number >= divideBy) {
			result++;
			return result(number - divideBy, divideBy, result);
		} else {
			return result;
		}
	}
}
