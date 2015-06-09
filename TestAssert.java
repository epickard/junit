package junitAssert;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

//Assert Same/Not Same
public class TestAssert {
	@Test
	public void testAssertSameString() {
		String a = "hello";
		String b = "hello";
		assertSame("Objects are not the same.", a, b);
	}
	
	@Test
	public void testAssertSameInt() {
		int a = 1;
		int b = 1;
		assertSame(a, b);
	}
	
	@Test
	public void testAssertNotSameString() {
		String a = "hello";
		String b = "Hello";
		assertNotSame(a, b);
	}
	
	@Test
	public void testAssertNotSameInt() {
		int a = 1;
		int b = 2;
		assertNotSame(a, b);
	}

//Assert Equals
	@Test
	public void testAssertEqualsStrings() {
		String a = "hello";
		String b = "hello";
		assertEquals(a,b);
	}
	
	@Test
	public void testAssertEqualsDoubles() {
		Double a = 10.1234;
		Double b = 11.0000;
		Double expectedDelta = 1.85;
		assertEquals("Delta greater than allowed.", a, b, expectedDelta);
		//Junit's expected/actual messaging is confusing here: java.lang.AssertionError: Delta greater than allowed. expected:<10.1234> but was:<12.0>
	}
	
	@Test
	public void testAssertNotEquals() {
		String a = "hello";
		String b = "Hello";
		assertNotEquals(a,b);
	}

//Assert That(T actual, org.hamcrest.Matcher<T> matcher)
	//Equality
	@Test
	public void testAssertThatIsForEquality() {
		String a = "hello";
		assertThat(a, is("hello"));
	}
	
	@Test
	public void testAssertThatIsNotForEquality () {
		String a = "hello";
		assertThat(a, is(not("Hello")));
	}
	
	@Test
	public void testAssertThatIs() {
		String a = "hello";
		assertThat(a, is(equalTo("hello")));
	}
	
	@Test
	public void testAssertThatIsEqualWithMsg() {
		String a = "hello";
		String msg = "Compared Objects are not same";
		assertThat(msg, a, is(equalTo("hello")));
	}
	
	@Test
	public void testAssertThatIsNotEqual() {
		String a = "hello";
		assertThat(a, is(not(equalTo("Hello"))));
	}
	
	
	@Test
	public void testEquals() {
			String aName = new String("emily");
			String anotherName = new String("emily");
			System.out.println(aName == anotherName);
	}
	
	@Test
	public void testEqualTo() {
		String aName = new String("emily");
		String anotherName = new String("emily");
		System.out.println(aName.equals(anotherName));
	}
	
//Assert True
	
	
//Fail
}
