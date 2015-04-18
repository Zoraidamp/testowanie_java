package zad01.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;
import zad01.main.Gra;
import zad01.main.NieudanyPsikusException;

@RunWith(Parameterized.class)

public class BadInputTest {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	Gra gry = new Gra();;
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{-9}, {-4}, {-3}, {-1}, {0}, {1}, {3}, {4}, {9}
           });
    }
  @Parameter
    public int Input;

  	@Test(expected = NieudanyPsikusException.class) 
	public void hultajchochlaTest() throws NieudanyPsikusException{
		gry.hultajchochla(Input);
	}
	
    public void CyfrokradTest() {
  	assertEquals(null, gry.cyfrokrad(Input));
  	}
}
