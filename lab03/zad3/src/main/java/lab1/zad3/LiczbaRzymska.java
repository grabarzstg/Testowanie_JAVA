package lab1.zad3;

import java.util.LinkedHashMap;
import java.util.Map;

public class LiczbaRzymska {
	
	private static int number = 0;
	private static String result = new String();
	
	private static Map<String, Integer> rMap = new LinkedHashMap<String, Integer>();
	
	public LiczbaRzymska(){
		number = 0;
		setRomanNumeralMap();
	}
		
	public void setValue(int a){
		result = "";
		number = a;
	}
	
	public void setRomanNumeralMap(){
		rMap.put("M",  1000);
		rMap.put("CM", 900);
		rMap.put("D",  500);
		rMap.put("CD", 400);
		rMap.put("C",  100);
		rMap.put("XC", 90);
		rMap.put("L",  50);
		rMap.put("XL", 40);
		rMap.put("X",  10);
		rMap.put("IX", 9);
		rMap.put("V",  5);
		rMap.put("IV", 4);
		rMap.put("I",  1);
	}

	public String toString(){
		if (number<1 || number>3999){
			throw new IllegalArgumentException();
		}
		rMap.forEach((k, v) -> {
			while (number >= v){
				result += k;
				number -= v;
			}
		});
		return result;
	}
}