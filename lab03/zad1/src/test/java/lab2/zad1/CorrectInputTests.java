package lab2.zad1;


import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import lab2.zad1.Dowcip;
import lab2.zad1.Psikus.NieudanyPsikusException;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CorrectInputTests {
	private Dowcip dowcip;
	
    @Parameters
    public static Collection<Object[]> nieksztaltekdata() {
        return Arrays.asList(new Object[][] {     
        		{611234322, "6", Arrays.asList("1", "2", "3", "4", "5")},
        		{723327131, "7", Arrays.asList("1", "2", "3", "4", "5")}, 
        		{113265756, "3", Arrays.asList("1", "2", "3", "4", "5")}, 
        		{124598014, "7", Arrays.asList("1", "2", "3", "4", "5")}
           });
    }
    private int nInput;
    private String nExpected;
    private List<String> hExpected;
    

    public CorrectInputTests(int input, String nexpected, List<String> hexpected) {
        nInput= input;
        nExpected = nexpected;
        hExpected = hexpected;
    }

	@Before
	public void prepare(){
		dowcip = new Dowcip();
	}
	
	@Test
	public void cyfrokradTest(){
		assertThat(Integer.toString(dowcip.cyfrokrad(nInput)).length(), is(Integer.toString(nInput).length()-1));
	}
	
	@Test
	public void cyfrokradTest2(){
		assertThat(dowcip.cyfrokrad(1234), anyOf(is(234), is(134), is(124), is(123)));
	}
	
	@Test
	public void hultajchochlaTest(){
		try{
			String result = Integer.toString(dowcip.hultajchochla(12345));
			for(String x : hExpected){
					assertThat(result, containsString(x));
			}
		}
		catch(NieudanyPsikusException e){
			fail("NieudanyPsikusException");		
		}
	}
	
	@Test
	public void nieksztaltekTest(){
		assertThat(Integer.toString(dowcip.nieksztaltek(nInput)), anyOf(not(containsString(nExpected)), is(Integer.toString(nInput))));
	}
}
