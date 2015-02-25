package zad1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private static int b;
	private static int a;

	@Before
	public void prepare() {
	a = 4;
	b = 2;	
	}
	
	@Test
	public void AddTest(){
		assertEquals(Calculator.add(a, b), 6);
	}
	
	@Test
	public void SubTest(){
		assertEquals(Calculator.sub(a, b), 2);		
	}
	
	@Test
	public void MultiTest(){
		assertEquals(Calculator.multi(a, b), 8);
	}
	
	@Test
	public void DivTest(){
		assertEquals(Calculator.div(a, b), 2);
	}
	
	@Test
	public void DivTestZero(){
		try{
		Calculator.div(a, 0);
		}
		catch(ArithmeticException e){
			fail(e.getMessage());
		}
	}
}
