package com.birin.others;


public class SieveOfEratosthenes {

	public int getTotalPrimes(int n) {
		boolean[] primeChecks = new boolean[n + 1];
		int prime = 2;
		while (prime < Math.sqrt(n)) {
			if (primeChecks[prime] == false) {
				int temp;
				for (int i = prime; (temp = prime * i) <= n; i++) {
					primeChecks[temp] = true;
				}
			}
			prime++;
		}
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (primeChecks[i] == false) {
				total++;
			}
		}
		return total;
	}
}
