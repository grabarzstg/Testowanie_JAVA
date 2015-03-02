package test;
import src.Calculator;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	private static int b;
	private static int a;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void prepare() {
	a = 4;
	b = 2;	
	}
	
	@Test
	public void addTest(){
		assertEquals(Calculator.add(a, b), 6);
	}
	
	@Test
	public void subTest(){
		assertEquals(Calculator.sub(a, b), 2);		
	}
	
	@Test
	public void multiTest(){
		assertEquals(Calculator.multi(a, b), 8);
	}
	
	@Test
	public void divTest(){
		assertEquals(Calculator.div(a, b), 2);
	}
	
	@Test
	public void divTestZero(){
		thrown.expect(ArithmeticException.class);
		Calculator.div(a, 0);
	}
	
	@Test
	public void greaterTest(){
		assertTrue(Calculator.greater(a, b));
		assertFalse(Calculator.greater(b, a));
	}
}
