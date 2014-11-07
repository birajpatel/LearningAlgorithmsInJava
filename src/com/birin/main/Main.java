package com.birin.main;

import com.birin.datastructures.linkedlists.Problem5;

public class Main {

	public static void main(String[] args) {
		Problem5 prob = new Problem5(Utils.getRandomData());
		System.out.println(prob.solution(5));
	}
}
