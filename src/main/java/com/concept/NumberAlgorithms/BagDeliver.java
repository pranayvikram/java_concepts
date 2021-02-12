package com.concept.NumberAlgorithms;

public class BagDeliver {

	/**
	 * Big Bag = 5Kg
	 * Small bag = 1Kg
	 * Goal = Required to deliver
	 * @param args
	 */
	public static void main(String[] args) {

		BagDeliver bagDeliver = new BagDeliver();
		boolean isPossible = bagDeliver.deliver(3,4,14);
		System.out.println(isPossible);
	}

	private boolean deliver(int bigBags, int smallBags, int goal) {
		
		int tempGoal = 0;
		int count = 0;
		while(count <= bigBags) {
			tempGoal = goal - count * 5;
			if (smallBags >= tempGoal && tempGoal >= 0) {
				return true;
			}
			count++;
		}
		return false;
	}
}
