package impl;


public interface Psikus {

	public int cyfrokrad(int liczba);
	public int hultajchochla(int liczba) throws NieudanyPsikusException;
	public int nieksztaltek(int liczba);
	
	@SuppressWarnings("serial")
	public class NieudanyPsikusException extends Exception {};
}

