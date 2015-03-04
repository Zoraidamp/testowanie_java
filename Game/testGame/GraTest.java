package testGame;

import org.junit.*;

import org.junit.Test;

import zad01.Calculator;


public class GraTest {
	Gra gry = new Gra();
	
	@Test
	public void testCyfrokrad() {
		Integer x = 1245;
		Assert.assertEquals(x,gry.cyfrokrad(12345));
	}

	@Test
	public void testHultajchochla() {
		//fail("Not yet implemented");
	}

	@Test
	public void testNieksztaltek() {
		//fail("Not yet implemented");
	}

}
