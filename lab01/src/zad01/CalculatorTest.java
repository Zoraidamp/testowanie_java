package zad01;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator(); 
	
	@Test
	public void checkAddCorrect() {
		assertEquals(5, calc.add(2, 3));
	}
	
	@Test
	public void checkSubCorrect() {
		assertEquals(calc.sub(7, 3), 4);
	}

	@Test
	public void checkMultiCorrect() {
		assertEquals(calc.multi(3, 4), 12);
	}
	
	@Test
	public void checkDivCorrectResultInt() {
		assertEquals(5, calc.div(10, 2));
	}
	
	@Test
	public void checkDivCorrectResultNotInt() {
		assertEquals(2, calc.div(15, 7));
	}
	
	@Test
	public void checkGreaterFirstGreater() {
		assertEquals(true, calc.greater(15, 7));
		
	}
	
	@Test
	public void checkGreaterSecondGreater() {
		assertEquals(false, calc.greater(4, 7));
		
	}
	
	@Test
	public void checkGreaterTwoEqual() {
		assertEquals(false, calc.greater(4, 4));
		
	}
	@Test(expected = ArithmeticException.class)  
	public void divisionWithException() {  
		calc.div(15, 0);
	} 
	
}
