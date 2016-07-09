package number;

import static org.junit.Assert.*;

import org.junit.Test;

public class decToGrkTest {

	@Test
	public void test() {
		String result = Greek.decToGrk(13);
		assertEquals("É'Ã'",result);
	}

}
