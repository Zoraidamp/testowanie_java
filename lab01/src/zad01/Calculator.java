package zad01;

public class Calculator {

	public int add(int a, int b){
		return a+b;
	}
	
	public int sub(int a, int b){
		return a-b;
	}
	
	public int multi(int a, int b){
		return a*b;
	}
	
	public int div(int a, int b){
		if (b == 0) throw new ArithmeticException();
		return a/b;
	}
	
	public boolean greater(int a, int b){
		return a>b ? true : false; 
	}
}
