package number;

import static org.junit.Assert.*;

import org.junit.Test;

public class romanToDecimalTest {

	@Test
	public void test() {
		Arabic_System rb = new Arabic_System();
		int result = rb.romanToDecimal("XIV");
		assertEquals(14,result);
	}

}
