package com.example.gaming;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class HultajchochlaTest {
	Gra gry = new Gra();
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12}, {13}, {14}, {15}, {16}
           });
    }
    @Parameter
    public int Input;
  
	@Test
	public void hultajchochlaTwoTest() throws NieudanyPsikusException{
		Integer pom=21;
		assertEquals(pom, gry.hultajchochla(12));
	}
	
	@Test
	public void hultajchochlaThreeTest() throws NieudanyPsikusException{
		assertThat(gry.hultajchochla(123), either(is(321)).or(is(213)).or(is(132)));
	}
	
	@Test
	public void hultajchochlaFourTest() throws NieudanyPsikusException{
		assertThat(gry.hultajchochla(1234), either(is(2134)).or(is(3214)).or(is(4231)).or(is(1324)).or(is(1432)).or(is(1243)));
	}
}
