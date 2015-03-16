package lab2.zad1;

import java.util.Random;

public class Dowcip implements Psikus {

	public Integer cyfrokrad(Integer liczba)
	{
		if (liczba > -10 && liczba < 10){
			return null;
		}
		Random rnd = new Random();
		char array[] = Integer.toString(liczba).toCharArray();
		array[rnd.nextInt(array.length)] =  ' ';
		liczba = Integer.parseInt(String.valueOf(array).replaceAll("\\s",""));
		return liczba;
	};
	
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException
	{
		if((liczba > (-10)) && (liczba < 10)){
			throw new NieudanyPsikusException();
		}
		
		char array[] = Integer.toString(liczba).toCharArray();
		Random rnd = new Random();
		int first = rnd.nextInt(array.length);
		int second = rnd.nextInt(array.length);
		while (first == second){
			second = rnd.nextInt(array.length); 
		}
		char temp = array[first];
		array[first] = array[second];
		array[second] = temp;
		liczba = Integer.parseInt(String.valueOf(array));
		return liczba;
	};
	
	public Integer nieksztaltek(Integer liczba)
	{
		char array[] = Integer.toString(liczba).toCharArray();
		for(int i = 0; i<array.length; i++){
			if (String.valueOf(array[i]).equals("3")){
				array[i] = '8';
			}
			else if(String.valueOf(array[i]).equals("7")){
				array[i] = '1';
			}
			else if(String.valueOf(array[i]).equals("6")){
				array[i] = '9';
			}
		}
		
		liczba = Integer.parseInt(String.valueOf(array));
		return liczba;
	};
}
