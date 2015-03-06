package impl;

import impl.Psikus.NieudanyPsikusException;

public class PsikusImpl implements Psikus {

	public int cyfrokrad(int liczba)
	{
		if (liczba < -9 && liczba > 9){
			return Integer.parseInt(null);
		}
	//	liczba -= liczba%
		return 0;
	};
	public int hultajchochla(int liczba) throws NieudanyPsikusException
	{
		return 0;
	};
	public int nieksztaltek(int liczba)
	{
		String temp = Integer.toString(liczba);		
		int licz = Integer.parseInt(temp);
		
		return licz;
	};
}
