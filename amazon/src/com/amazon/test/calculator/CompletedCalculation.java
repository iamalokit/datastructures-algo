package com.amazon.test.calculator;

public class CompletedCalculation {
	private int augend;
	private int addend;
	private int sum;
	
	public CompletedCalculation(int augend, int addend, int sum) {
		this.augend = augend;
		this.addend = addend;
		this.sum = sum;
	}

	public int getAugend() {
		return augend;
	}

	public void setAugend(int augend) {
		this.augend = augend;
	}

	public int getAddend() {
		return addend;
	}

	public void setAddend(int addend) {
		this.addend = addend;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
