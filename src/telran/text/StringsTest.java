package telran.text;
import static org.junit.jupiter.api.Assertions.*;

import static telran.text.Strings.*;
import org.junit.jupiter.api.*;

class StringsTest {
String word="yellow";
	@Test
	//@Disabled
	void sortStringsNumbersTest() {
		String array[] = {"127", "-128", "0", "25", "25", "-128", "127"};
		String expected[] = {"-128", "-128", "0", "25", "25", "127", "127"};
		Strings.sortStringNumbers(array);
		assertArrayEquals(expected, array);
	}
	@Test
	//@Disabled
	void isAnagramTest() {
		
		assertTrue(Strings.isAnagram(word, "loweyl")); 
		assertTrue(Strings.isAnagram(word, "elolyw")); 
		assertTrue(Strings.isAnagram(word, "wolley")); 
		assertTrue(Strings.isAnagram(word, "loleyw")); 
		assertTrue(Strings.isAnagram("yttttoooo", "ooootttty"));
		assertFalse(Strings.isAnagram(word,"")); 
		assertFalse(Strings.isAnagram(word, "yellob")); 
		assertFalse(Strings.isAnagram(word,"yello")); 
		assertFalse(Strings.isAnagram(word,"yelllo")) ;
		assertFalse(Strings.isAnagram(word, "wolkez"));
		assertFalse(Strings.isAnagram(word, "yeooow"));
		assertFalse(Strings.isAnagram("yttttoooo", "yoootttty"));
	}
	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
		
		
	}
	@Test
	void ipV4TestTrue() {
		assertTrue("1.2.3.4".matches(ipV4()));
		assertTrue("199.249.255.209".matches(ipV4()));
		assertTrue("99.99.99.05".matches(ipV4()));
	}
	@Test
	void ipV4TestFalse() {
		assertFalse("*.19.10.10".matches(ipV4()));
		assertFalse("256.19.10.10".matches(ipV4()));
		assertFalse("300.19.10.10".matches(ipV4()));
		assertFalse("255.19.10".matches(ipV4()));
		assertFalse("255.19.10.10.".matches(ipV4()));
		assertFalse("255.19".matches(ipV4()));
	}
	@Test
	void computeExpressionTest() {
		assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null)));
		assertEquals(10.5, computeArithmenticExpression("a + 2 + c * 2 + 0.5", new double[] {2, 1},
				new String[] {"a", "c"}));
		assertTrue(Double.isNaN(computeArithmenticExpression("a + 2 + c * 2 + d23", new double[] {2, 1},
				new String[] {"a", "c"})));
	}
	
	
	

}
