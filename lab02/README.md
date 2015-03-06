## Laboratorium 2

Dany jest interfejs (kontrakt), który jest częścią oprogramowania pewnej gry dla dzieci.
Interfejs należy zaimplementować a następnie przetestować jednostkowo przy użyciu JUnit.

		public interface Psikus {
		Integer cyfrokrad(Integer liczba);
		Integer hultajchochla(Integer liczba) throws NieduanyPsikusException;
		Integer nieksztaltek(Integer liczba);
		}
        
		public class NieudanyPsikusException extends Exception {};

Kontrakt (specyfikacja) metod:
1. Metoda `cyfrokrad` działa w ten sposób, że w liczbie przekazanej jako argument usuwa losowo jedną cyfrę. Uwaga: Gdy liczba jest jednocyfrowa metoda zwraca _null_;
2. Metoda `hultajchochla` działa w ten sposób, że losowo zmienia wystąpienia dwóch cyfr w liczbie będącej argumentem. Uwaga Gdy liczba jest jednocyfrowa metoda wyrzuca _NieduanyPsikusException_
3. Metoda `niekształtek` działa w ten sposób, że w zadanej liczbie dokonuje jednej losowej zmiany cyfr wg podanego schematu:
`3 -> 8`
`7 -> 1`
`6 -> 9`

  Uwaga: cyfry 3, 7, 6 mogą nie występować w liczbie będącej argumentem, metoda        zwraca wówczas swój argument.

Uwagi ogólne:
1. Przy rozwiązaniu zadania spróbować podejścia _Test Driven Development_ tj. najpierw spróbować napisać kod samych testów a poźniej właściwą impelementację metod. Zazwyczaj takie podejście bardzo pomaga w implementacji.
2. Zastosować wywołania paramteryczne, utworzyć suite, skorzystać z matchers (_JUnit_ wraz z biblioteką _Hamcrest_)
3. Zwrócić uwagę i odpowiednio przetestować przypadki brzegowe - tj. wyrzucane wyjątki lub zwaracane wartości _null_

_Źródło:_ [KLIK](https://inf.ug.edu.pl/~jdybiz/taj/index.php)