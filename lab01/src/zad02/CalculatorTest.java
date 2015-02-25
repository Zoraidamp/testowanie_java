package zad02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator(); 
	
	@Test
	public void checkAddCorrect() {
		assertEquals(calc.add(2, 3), 5,0.001);
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
		assertEquals(calc.div(10, 2), 5);
	}
	
	@Test
	public void checkDivCorrectResultNotInt() {
		assertEquals(calc.div(15, 7), 2);
	}
	
	@Test
	public void checkGreaterFirstGreater() {
		assertEquals(calc.greater(15, 7), true);
		
	}
	
	@Test
	public void checkGreaterSecondGreater() {
		assertEquals(calc.greater(4, 7), false);
		
	}
	
	@Test
	public void checkGreaterTwoEqual() {
		assertEquals(calc.greater(4, 4), false);
		
	}
	@Test(expected = ArithmeticException.class)  
	public void divisionWithException() {  
		calc.div(15, 0);
	} 
	
}
