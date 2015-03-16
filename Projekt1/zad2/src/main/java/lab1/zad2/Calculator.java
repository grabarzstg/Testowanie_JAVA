package lab1.zad2;

public class Calculator {
	public static double add (double a, double b){
		return a+b;
	}
	
	public static double substract (double a, double b){
		return a-b;
	}
	
	public static double multiply (double a, double b){
		return a*b;
	}
	
	public static double divide (double a, double b){
		if(b==0){
			throw new ArithmeticException();
		}
		else{
			return a/b;
		}
	}
	
	public static boolean isGreater (double a, double b){
		if(a>b){
			return true;
		}
		else{
			return false;
		}
	}
}