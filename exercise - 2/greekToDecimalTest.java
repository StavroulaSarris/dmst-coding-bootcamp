package number;

import static org.junit.Assert.*;

import org.junit.Test;

public class greekToDecimalTest {

	@Test
	public void test() {
		Arabic_System rb = new Arabic_System();
		int result = rb.greekToDecimal("�'�'",Greek.values,Greek.digrams);
		assertEquals(11,result);
	}

}
