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

public class CyfrokradTest {
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
	public void testCyfrokradSix() {
		assertThat(gry.cyfrokrad(123456), either(is(23456)).or(is(13456)).or(is(12456)).or(is(12356)).or(is(12346)).or(is(12345))  );
	}
	@Test
	public void testCyfrokradFive() {
		assertThat(gry.cyfrokrad(12345), either(is(2345)).or(is(1345)).or(is(1245)).or(is(1235)).or(is(1234)) );
	}
	
	@Test
	public void testCyfrokradFour() {
		assertThat(gry.cyfrokrad(1234), either(is(234)).or(is(134)).or(is(124)).or(is(123)));
	}
	
	@Test
	public void testCyfrokradThree() {
		assertThat(gry.cyfrokrad(123), either(is(23)).or(is(13)).or(is(12)));
	}
}
