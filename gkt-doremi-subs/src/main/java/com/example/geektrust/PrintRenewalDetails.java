package com.example.geektrust;

public class PrintRenewalDetails {
	private Subscription subscription;
	private ITopup topup;

	PrintRenewalDetails(Subscription subscription, ITopup topup) {
		this.subscription = subscription;
		this.topup = topup;
	}

	public void print() {
		Integer totalCost = 0;
		for (IStream stream : subscription.streams()) {
			System.out.println("RENEWAL_REMINDER " + stream.streamName() + " " + stream.getRenewal());
			totalCost += stream.getCost();
		}
		totalCost += (topup != null) ? topup.cost() : 0;
		System.out.println("RENEWAL_AMOUNT" + " " + totalCost);
	}

}
