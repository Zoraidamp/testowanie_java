package zad01.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CorrectInputTest.class,
	BadInputTest.class
	})

public class GraTest {}
/*Gra gry = new Gra();
	
	@Test
	public void testCyfrokrad() {
		assertThat(gry.cyfrokrad(12345), either(is(2345)).or(is(1345)).or(is(1245)).or(is(1235)).or(is(1234)) );
	}

	@Test
	public void hultajchochlaTest() throws NieudanyPsikusException{
		assertThat(gry.hultajchochla(123), either(is(321)).or(is(213)).or(is(132)));
	}
	
	@Test
	public void nieksztaltekTest(){
		assertEquals(null, gry.nieksztaltek(1123456));
	}
	*/