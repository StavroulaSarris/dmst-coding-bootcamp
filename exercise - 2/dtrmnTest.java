package number;

import static org.junit.Assert.*;

import org.junit.Test;

public class dtrmnTest {

	@Test
	public void test() {
		String result = Roman.dtrmn(13);
		assertEquals("XIII",result);
	}

}
