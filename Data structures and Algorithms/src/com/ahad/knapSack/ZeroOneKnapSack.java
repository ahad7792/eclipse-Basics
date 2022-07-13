package com.ahad.knapSack;

public class ZeroOneKnapSack {

	// how will you fill out particular cell of answer matrix
	// need a profit array p[] for particular items profit
	// m[i,w] -> i for particular item, weight belongs to w

	// max(m[i-1, w], m[i-1, w - w[i] + p[i]])
	// finding the total weight after taking the certain one and remaining weight
	// stepping up to the upper cell
	// suppose [5,5] -> max(m[3, 7], m[3, 7-6] + 1)

	

	public static void main(String[] args) {

		int[] weights = { 2, 3, 4, 5 };
		int[] profitValues = { 1, 2, 5, 6 };
		
		KnapSack knapSack = new KnapSack(weights.length - 1, 8, weights, profitValues);
		
		System.out.println(knapSack.solve());

	}
}

