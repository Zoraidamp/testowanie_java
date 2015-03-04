package testGame;

import java.util.Random;
public class Gra implements Psikus{

	@Override
	public Integer cyfrokrad(Integer liczba) {
		if (liczba<10) return null;
		char[] chars = ("" + liczba).toCharArray();
		//Random generator = new Random();
		//int nr = generator.nextInt(chars.length);
		int nr = 2;
		StringBuilder build = new StringBuilder();
		build.deleteCharAt(nr);
		liczba = Integer.parseInt(new String(chars));
		return liczba;
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}

}
