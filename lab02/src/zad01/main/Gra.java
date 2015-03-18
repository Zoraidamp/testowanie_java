package zad01.main;

import java.util.ArrayList;
import java.util.Random;

public class Gra implements Psikus{

	@Override
	public Integer cyfrokrad(Integer liczba) {
		int solution = 0;
		if (liczba<10) return null;
	    String stringNumber = "" + liczba;
		Random generator = new Random();
		int nr = generator.nextInt(stringNumber.length());
		StringBuilder build = new StringBuilder(stringNumber);
		build.deleteCharAt(nr);
		
		solution = Integer.parseInt( (build.toString()) );
		return solution;
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		int solution = 0, rand1=0, rand2=0;
		char pom;
		if (liczba<10) throw new NieudanyPsikusException();
		String stringNumber = "" + liczba;
		Random generator = new Random();
		while(rand1 == rand2){
			rand1 = generator.nextInt(stringNumber.length());
			rand2 = generator.nextInt(stringNumber.length());
		}
		StringBuilder build = new StringBuilder(stringNumber);
		pom = build.charAt(rand1);
		build.setCharAt(rand1, build.charAt(rand2));
		build.setCharAt(rand2, pom);
		//System.out.println(rand1 +" "+rand2);
		solution = Integer.parseInt( (build.toString()) );
		//System.out.println(solution);
		return solution;
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		String data = liczba.toString();
		char pom = '2';
		int pos = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		while ((pos = data.indexOf("3", pos)) != -1) {
		    list.add(pos);
		    pos++;
		}
		while ((pos = data.indexOf("6", pos)) != -1) {
		    list.add(pos);
		    pos++;
		}
		while ((pos = data.indexOf("7", pos)) != -1) {
		    list.add(pos);
		    pos++;
		}
		System.out.println("i"+list);
		if (list.size() > 0){
			Random generator = new Random();
			int nr = generator.nextInt(list.size());
			int nrList = list.get(nr);
			System.out.println("nr: "+nrList);
			System.out.println("size:"+nrList);
			StringBuilder build = new StringBuilder(data);
			if ( build.charAt(nrList)=='3') build.setCharAt(nrList, '8');
			if (build.charAt(nrList)=='6') build.setCharAt(nrList, '9');
			if (build.charAt(nrList)=='7') build.setCharAt(nrList, '1');
			System.out.println( "build:"+ build.toString());
			liczba = Integer.parseInt( (build.toString()) );
		}
		return liczba;
	}

}
