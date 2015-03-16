package lab1.zad2;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lab1.zad2.Calculator;


public class CalculatorTest {

	private static double a;
	private static double b;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void prepareData(){
		a = 4.4;
		b = 2.2;
	}
	
	@Test
	public void addTest(){
		assertEquals(6.6, Calculator.add(a, b), 0.000001);
		//Asserts that two doubles or floats are equal to within a positive delta.
	}
	
	@Test
	public void substractTest(){
		assertEquals(2.2, Calculator.substract(a, b), 0.000001);
	}
	
	@Test
	public void multiplyTest(){
		assertEquals(9.68, Calculator.multiply(a, b), 0.000001);
	}
	
	@Test
	public void divideTest(){
		assertEquals(2, Calculator.divide(a, b), 0.000001);
	}
	
	@Test
	public void divideByZeroTest(){
		thrown.expect(ArithmeticException.class);
		Calculator.divide(a, 0);
	}
	
	@Test
	public void greaterTest(){
		assertTrue(Calculator.isGreater(a, b));
		assertFalse(Calculator.isGreater(b, a));
	}
}