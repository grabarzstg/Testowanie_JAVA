package src;

public class Calculator {
	
	public static int add(int a, int b){
		return a+b;
	}
	
	public static int sub(int a, int b){
		return a-b;
	}
	
	public static int multi(int a, int b){
		return a*b;
	}
	
	public static int div(int a, int b){
		return a/b;
	}
	
	public static boolean greater(int a, int b){
		if (a>b){
			return true;
		}
		else{
			return false;
		}
	}

}
