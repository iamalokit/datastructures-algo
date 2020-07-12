package com.amazon.test.calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
	private final List<CompletedCalculation> calculations = new ArrayList<CompletedCalculation>();
	
	public void append(CompletedCalculation calculation) {
		calculations.add(calculation);
	}

}
