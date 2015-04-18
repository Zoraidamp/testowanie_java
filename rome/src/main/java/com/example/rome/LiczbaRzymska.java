package com.example.rome;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LiczbaRzymska {

	private int Arab;
	
	public LiczbaRzymska(int number){
		Arab = number;
	}
	
	public String toString(){
		int numb = Arab;
		String roman="";
		Map<Integer, String> mapRoman = new LinkedHashMap<Integer, String>();
		
		mapRoman.put(1000, "M");
		mapRoman.put(900, "CM");
		mapRoman.put(500, "D");
		mapRoman.put(400, "CD");
		mapRoman.put(100, "C");
		mapRoman.put(90, "XC");
		mapRoman.put(50, "L");
		mapRoman.put(40, "XL");
		mapRoman.put(10, "X");
		mapRoman.put(9, "IX");
		mapRoman.put(5, "V");
		mapRoman.put(4, "IV");
		mapRoman.put(1, "I");
		
		if (Arab <= 0) throw new NumberFormatException("Number must be greater or equal zero!");
		if (Arab > 3999) throw new NumberFormatException("Number can't be greater than 3999!");
		
		Set<Entry<Integer, String>> set = mapRoman.entrySet();
	    Iterator<Entry<Integer, String>> itr = set.iterator();
	      
		while(itr.hasNext()){
			Entry<Integer, String> here = itr.next();
			//System.out.println(here.getKey()+": "+here.getValue());
			while(numb >= (Integer)here.getKey()){
				roman += here.getValue();
				numb -= (Integer)here.getKey();
			}
		}
		return roman;
		
	}

}
