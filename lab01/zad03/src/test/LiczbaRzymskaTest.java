package test;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.LiczbaRzymska;

public class LiczbaRzymskaTest {

	private static Map<String, Integer> outputSrc = new LinkedHashMap<String, Integer>();
	private LiczbaRzymska liczba = new LiczbaRzymska();
		
	@Before
	public void setOutputSource(){
		outputSrc.put("I", 1);
		outputSrc.put("II", 2);
		outputSrc.put("III", 3);
		outputSrc.put("IV", 4);
		outputSrc.put("V", 5);
		outputSrc.put("VI", 6);
		outputSrc.put("VII", 7);
		outputSrc.put("VIII", 8);
		outputSrc.put("IX", 9);
		outputSrc.put("X", 10);
		outputSrc.put("L", 50);
		outputSrc.put("C", 100);
		outputSrc.put("D", 500);
		outputSrc.put("M", 1000);
		outputSrc.put("XXXI", 31);
		outputSrc.put("CXLVIII", 148);
		outputSrc.put("CCXCIV", 294);
		outputSrc.put("CCCXII", 312);
		outputSrc.put("CDXXI", 421);
		outputSrc.put("DXXVIII", 528);
		outputSrc.put("DCXXI", 621);
		outputSrc.put("DCCLXXXII", 782);
		outputSrc.put("DCCCLXX", 870);
		outputSrc.put("CMXLI", 941);
		outputSrc.put("MXLIII", 1043);
		outputSrc.put("MCX", 1110);
		outputSrc.put("MCCXXVI", 1226);
		outputSrc.put("MCCCI", 1301);
		outputSrc.put("MCDLXXXV", 1485);
		outputSrc.put("MDIX", 1509);
		outputSrc.put("MDCVII", 1607);
		outputSrc.put("MDCCLIV", 1754);
		outputSrc.put("MDCCCXXXII", 1832);
		outputSrc.put("MCMXCIII", 1993);
		outputSrc.put("MMLXXIV", 2074);
		outputSrc.put("MMCLII", 2152);
		outputSrc.put("MMCCXII", 2212);
		outputSrc.put("MMCCCXLIII", 2343);
		outputSrc.put("MMCDXCIX", 2499);
		outputSrc.put("MMDLXXIV", 2574);
		outputSrc.put("MMDCXLVI", 2646);
		outputSrc.put("MMDCCXXIII", 2723);
		outputSrc.put("MMDCCCXCII", 2892);
		outputSrc.put("MMCMLXXV", 2975);
		outputSrc.put("MMMLI", 3051);
		outputSrc.put("MMMCLXXXV", 3185);
		outputSrc.put("MMMCCL", 3250);
		outputSrc.put("MMMCCCXIII", 3313);
		outputSrc.put("MMMCDVIII", 3408);
		outputSrc.put("MMMDI", 3501);
		outputSrc.put("MMMDCX", 3610);
		outputSrc.put("MMMDCCXLIII", 3743);
		outputSrc.put("MMMDCCCXLIV", 3844);
		outputSrc.put("MMMDCCCLXXXVIII", 3888);
		outputSrc.put("MMMCMXL", 3940);
		outputSrc.put("MMMCMXCIX", 3999);
		outputSrc.put("MMMM", 4000);
		outputSrc.put("MMMMD", 4500);
		outputSrc.put("MMMMDCCCLXXXVIII", 4888);
		outputSrc.put("MMMMCMXCIX", 4999);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void initializeTest(){
		try{
		new LiczbaRzymska();
		}
		catch (Exception e){
			fail(e.getMessage());
		}
	}
	
	//Wykorzystanie wczesniejszej adnotacji @Rule
	@Test  
	public void toStringBadInputLowerTest(){ 
		thrown.expect(IllegalArgumentException.class);
		liczba.setValue(0);
		liczba.toString();
	}
	
	//Wykorzystanie expected=Exception przy tworzeniu testu
	@Test(expected=IllegalArgumentException.class)  
	public void toStringBadInputGreaterTest(){
		liczba.setValue(5000);
		liczba.toString();
	}
	
	@Test
	public void toStringTest(){
		if(outputSrc.isEmpty()){
			fail("Brak danych testowych");
		}
		outputSrc.forEach((k, v) -> {
			liczba.setValue(v);
			assertEquals(k, liczba.toString());
		});
	}
}