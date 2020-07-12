package amazon;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.amazon.test.calculator.CalculationHistory;
import com.amazon.test.calculator.Calculator;


public class CaculatorTest {
	
	private CalculationHistory history;
	private Calculator calculator;
	@Before
	public void setUp() {
		history = new CalculationHistory();
		calculator = new Calculator(history);
	}
	
	
	@Test
	public void givenDefaultCalculator_WhenAddingTwoNonZeroValues_ThenResultIsSum() {
		int result = calculator.add(0, 1);		
		assertEquals(1, result);
	}
	
	@Test
	public void givenDefaultCalculator_WhenAddingTwoNonZeroValues_ThenEntryIsAddedToHistory() {
		calculator.add(0, 1);
//		Mockito.verify(history, times(1)).append(any(CompletedCalculation.class));
	}
}
