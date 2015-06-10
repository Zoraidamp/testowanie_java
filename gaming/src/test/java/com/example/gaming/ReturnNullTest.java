package com.example.gaming;

import java.util.Arrays;
import java.util.Collection;

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

public class ReturnNullTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	Gra gry = new Gra();
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}
           });
    }
  @Parameter
    public int Input;

  	@Test(expected = NieudanyPsikusException.class) 
	public void hultajchochlaTest() throws NieudanyPsikusException{
		gry.hultajchochla(Input);
	}
	
  	@Test
    public void CyfrokradTest() {
  	assertEquals(null, gry.cyfrokrad(Input));
  	}
}
