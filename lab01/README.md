# Laboratorium 1

**Zadanie 1a**  
Napisz klasę _Calculator_, która będzie dostarczała pięć publicznych metod:  

    int add(int a, int b)  
    int sub(int a, int b)  
    int multi(int a, in b)  
    int div(int a, int b) //(dzielenie całkowitoliczbowe)  
    boolean greater(int a, int b)  

Napisz klasę _CalculatorTest_, która będzie klasą testującą dla klasy _Calculator_.  
Zaplanuj i zaimplementuj odpowiednie przypadki testowe (sprawdzające poprawność wykonywanych operacji). Skorzystaj z różnych asercji.

**Zadanie 1b**  
Rozszerz klasę _CalculatorTest_ o przypadek testowy, który zakończy się błędem, gdy przy próbie dzielenia przez 0 nie wystąpi wyjątek typu _ArithmeticException_. 

**Zadanie 2**  
Napisz klasę _Calculator_, która będzie działała analogicznie do tej z zadania 1, ale będzie wykonywała operacje na liczbach typu _double_. Napisz klasę _CalculatorTest_ (zwróć uwagę na możliwe błędy w zaokrągleniach, jak sobie z tym poradzić?).

**Zadanie 3**  
Napisz klasę _LiczbaRzymska_, która będzie posiadała jedno _prywatne_ pole zawierające liczbę (zainicjalizowane w konstruktorze) i metodę _toString()_, która będzie zwracała tę samą liczbę zapisaną w rzymskim systemie zapisywania liczb.
Przed implementacją metody _toString()_ zastanów się jak powinna zachować się ta klasa w różnych przypadkach np. gdy w konstruktorze podano liczbę ujemną.
Zaimplementuj klasę testującą i odpowiednie przypadki testowe. W tym momencie testy oczywiście zakończą się niepowodzeniem. Zaimplementuj metodę _toString()_ i uruchom ponownie testy. 

Źródło: [Grupa 3I TE 1](https://inf.ug.edu.pl/~jdybiz/taj/index.php)
