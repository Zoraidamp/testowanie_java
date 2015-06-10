package zad01.test;

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
import zad01.main.Gra;
import zad01.main.NieudanyPsikusException;

@RunWith(Parameterized.class)

public class NieksztaltekTest {
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
	public void nieksztaltek1Test(){
		Integer pom=1;
		assertEquals(pom, gry.nieksztaltek(pom));
		//assertThat(gry.nieksztaltek(666), either(is(321)).or(is(213)).or(is(132)));
	}	
	
	@Test
	public void nieksztaltek2Test(){
		Integer pom=12;
		assertEquals(pom, gry.nieksztaltek(pom));
	}
	
	@Test
	public void nieksztaltek3Test(){
		Integer pom=128;
		assertEquals(pom, gry.nieksztaltek(123));
	}
	
	@Test
	public void nieksztaltek4Test(){
		Integer pom=1284;
		assertEquals(pom, gry.nieksztaltek(1234));
	}
	
	@Test
	public void nieksztaltek5Test(){
		Integer pom=12845;
		assertEquals(pom, gry.nieksztaltek(12345));
	}
	
	@Test
	public void nieksztaltek6Test(){
		assertThat(gry.nieksztaltek(123456), either(is(128456)).or(is(123459)));
	}
	
	@Test
	public void nieksztaltek7Test(){
		assertThat(gry.nieksztaltek(1234567), either(is(1284567)).or(is(1234597)).or(is(1234561)));
	}
	
	@Test
	public void nieksztaltek8Test(){
		assertThat(gry.nieksztaltek(12345678), either(is(12845678)).or(is(12345978)).or(is(12345618)));
	}
	
	@Test
	public void nieksztaltek9Test(){
		assertThat(gry.nieksztaltek(123456789), either(is(128456789)).or(is(123459789)).or(is(123456189)));
	}
}
