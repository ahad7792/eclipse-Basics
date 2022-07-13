package com.ahad.knapSack;

public class KnapSack {

	private int numOfItems;
	private int capacityOfKnapSack;
	private int[][] knapSackTable;
	private int totalBenefit;
	private int weights[];
	private int profitValues[];

	public KnapSack(int numOfItems, int capacityOfKnapSack, int[] weights, int[] profitValues) {

		this.numOfItems = numOfItems;
		this.capacityOfKnapSack = capacityOfKnapSack;
		this.weights = weights;
		this.profitValues = profitValues;
		this.knapSackTable = new int[numOfItems + 1][capacityOfKnapSack + 1];

	}

	public int solve() {
		for (int i = 1; i < numOfItems + 1; i++) {
			for (int w = 1; w < capacityOfKnapSack + 1; w++) {

				int notTakingItem = knapSackTable[i - 1][w];
				int takingItem = 0;

				if (weights[i] <= w) {
					takingItem = profitValues[i] + knapSackTable[i - 1][w - weights[i]];
				}

				knapSackTable[i][w] = Math.max(notTakingItem, takingItem);

			}
		}
		totalBenefit = knapSackTable[numOfItems][capacityOfKnapSack];
		return totalBenefit;
	}

}