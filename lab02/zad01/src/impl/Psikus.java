package impl;


public interface Psikus {

	public int cyfrokrad(int liczba);
	public int hultajchochla(int liczba) throws NieudanyPsikusException;
	public static int nieksztaltek(int liczba){
		return 0;
	};
	
	@SuppressWarnings("serial")
	public class NieudanyPsikusException extends Exception {};
}

