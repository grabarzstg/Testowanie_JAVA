package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import impl.Dowcip;
import impl.Psikus.NieudanyPsikusException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BadInputTests {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{ -9 }, { -1 },  { 9 }
           });
    }
    private int badInput;

    public BadInputTests(int input) {
        badInput= input;
    }
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	private Dowcip dowcip;

	@Before
	public void prepare(){
		dowcip = new Dowcip();
	}
	
	@Test
	public void hultajchochlaBadInputTest() throws NieudanyPsikusException{
		thrown.expect(NieudanyPsikusException.class);
		dowcip.hultajchochla(badInput);
	}
	
	@Test 
	public void cyfrokradBadInputTest(){
		assertThat(dowcip.cyfrokrad(badInput), is(0));
	}
}
