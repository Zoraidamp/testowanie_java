package com.example.rome;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class LiczbaRzymskaTest {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	LiczbaRzymska rom = new LiczbaRzymska(0);
	    @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { 1, "I" }, {2, "II"}, {3, "III"}, {4, "IV"}, {5, "V"}, {6, "VI"}, {7, "VII"}, {8, "VIII"}, {10, "X"}, {100, "C"}, {500, "D"}, {1000, "M"}, {31, "XXXI"}, {148, "CXLVIII"}, {294, "CCXCIV"}, {312, "CCCXII"}, {421, "CDXXI"}, {528, "DXXVIII"}, {621, "DCXXI"}, {782, "DCCLXXXII"}, {870, "DCCCLXX"}, {941, "CMXLI"}, {1043, "MXLIII"}, {1110, "MCX"}, {1226, "MCCXXVI"}, {1301, "MCCCI"}, {1485, "MCDLXXXV"}, {1509, "MDIX"}, {1607, "MDCVII"}, {1754, "MDCCLIV"}, {1832, "MDCCCXXXII"}, {1993, "MCMXCIII"}, {2074, "MMLXXIV"}, {2152, "MMCLII"}, {2212, "MMCCXII"}, {2343, "MMCCCXLIII"}, {2499, "MMCDXCIX"}, {2574, "MMDLXXIV"}, {2646, "MMDCXLVI"}, {2723, "MMDCCXXIII"}, {2892, "MMDCCCXCII"}, {2975, "MMCMLXXV"}, {3051, "MMMLI"}, {3185, "MMMCLXXXV"}, {3250, "MMMCCL"}, {3313, "MMMCCCXIII"}, {3408, "MMMCDVIII"}, {3501, "MMMDI"}, {3610, "MMMDCX"}, {3743, "MMMDCCXLIII"}, {3844, "MMMDCCCXLIV"}, {3888, "MMMDCCCLXXXVIII"}, {3940, "MMMCMXL"}, {3999, "MMMCMXCIX"} 
	           });
	    }
	  @Parameter // first data value (0) is default
	    public /* NOT private */ int rInput;

	  @Parameter(value = 1)
	    public /* NOT private */ String rExpected;
	
	@Test    
	public void CorrectNumberTest() {
			rom = new LiczbaRzymska(rInput);
			assertEquals(rExpected, rom.toString());
	}
	
	@Test(expected = NumberFormatException.class) 
	public void negativeNumberTest() {
		rom = new LiczbaRzymska(-10);
		rom.toString();
		thrown.expectMessage("Number must be greater or equal zero!");
	}
	
	@Test(expected = NumberFormatException.class) 
	public void zeroTest() {
		rom = new LiczbaRzymska(0);
		rom.toString();
		thrown.expectMessage("Number must be greater or equal zero!");
	}
	
	@Test(expected = NumberFormatException.class) 
	public void NumberGreaterThanExpectedTest() {
		rom = new LiczbaRzymska(4000);
		rom.toString();
		thrown.expectMessage("Number can't be greater than 3999!");
	}
	
}
