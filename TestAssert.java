package junitAssert;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

//Checkpoint checkin; dev in progress
public class TestAssert {
	//Create class variables
	String id;
	String id2;
	Integer int1;
	Integer int2;
	Double num1;
	Double num2;
	
	@Test
	public void testAssertSame() {
		id = "Hello";
		id2 = "Hello";
		assertSame("Objects are not the same.", id, id2);
	}
	
	@Test
	public void testAssertNotSame() {
		int1 = 1;
		int2 = 2;
		assertNotSame(int1, int2);
	}
	
	@Test
	public void testAssertEqualsWithDoubles() {
		num1 = 10.1234;
		num2 = 11.0000;
		Double expectedDelta = 1.85;
		assertEquals("Delta greater than allowed.", num1, num2, expectedDelta);
		//Junit's expected/actual messaging is confusing here: java.lang.AssertionError: Delta greater than allowed. expected:<10.1234> but was:<12.0>
	}
	
	@Test
	public void testAssertThatIs() {
		id = "resultStats";
		assertThat(id, is("resultStats"));
	}
}
