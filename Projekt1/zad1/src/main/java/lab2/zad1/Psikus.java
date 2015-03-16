package lab2.zad1;


public interface Psikus {

	public Integer cyfrokrad(Integer liczba);
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException;
	public Integer nieksztaltek(Integer liczba);
	
	@SuppressWarnings("serial")
	public class NieudanyPsikusException extends Exception {};
}

