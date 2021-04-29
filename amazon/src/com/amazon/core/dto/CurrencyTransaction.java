package com.amazon.core.dto;

public class CurrencyTransaction {
	private final Currency currency;
	private final double value;

	public CurrencyTransaction(Currency currency, double value) {
		this.currency = currency;
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return currency + " " + value;
	}
}
