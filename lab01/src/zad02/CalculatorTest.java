package zad02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator(); 
	
	@Test
	public void checkAddCorrect() {
		assertEquals(5.37, calc.add(2.12, 3.25),0.001);
	}
	
	@Test
	public void checkSubCorrect() {
		assertEquals(5.10, calc.sub(7.23, 2.13),0.001);
	}

	@Test
	public void checkMultiCorrect() {
		assertEquals(10.1675, calc.multi(2.45, 4.15),0.0001);
	}
	
	@Test
	public void checkDivCorrect() {
		assertEquals(3.5, calc.div(7, 2),0.001);
	}
	
	@Test
	public void checkGreaterFirstGreater() {
		assertEquals(calc.greater(15.34, 7), true);
		
	}
	
	@Test
	public void checkGreaterSecondGreater() {
		assertEquals(calc.greater(4.55, 7.1), false);
		
	}
	
	@Test
	public void checkGreaterTwoEqual() {
		assertEquals(calc.greater(4.1234, 4.1234), false);
		
	}
	@Test(expected = ArithmeticException.class)  
	public void divisionWithException() {  
		calc.div(15.4567, 0);
	} 
	
}
