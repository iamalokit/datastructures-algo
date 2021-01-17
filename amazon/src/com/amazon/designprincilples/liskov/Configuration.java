package com.amazon.designprincilples.liskov;

public class Configuration {
	private double quantityCoffee;
	private double quantityWater;
	
	public double getQuantityCoffee() {
		return quantityCoffee;
	}

	public double getQuantityWater() {
		return quantityWater;
	}

	public Configuration(double quantityCoffee, double quantityWater) {
		this.quantityCoffee = quantityCoffee;
		this.quantityWater = quantityWater;
	}
}
