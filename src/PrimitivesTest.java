import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {
		int b = 10;
		short a = 20000;
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1000;
		a = (short) l;
		float f = 10.2f;
		int b2 = 0xfffffff1;
		
		assertEquals(-15, b2);
	}
	@Test
	@Disabled
	void operatorsTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));
		
	}
	//Assumption: all three methods take number comprising of three digits
	private int getFirstDigit(int number) {
		
		return number / 100 % 10;
	}
	private int getSecondDigit(int number) {
		
		return number / 10 % 10;
	}
	private int getThirdDigit(int number) {
		
		return number % 10;
	}
	
	@Test
	@Disabled
	void getBitValueTest() {
		long num = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(1, BitOperations.getBitValue(num, 5));
		assertEquals(0, BitOperations.getBitValue(num, 11));
		assertEquals(0, BitOperations.getBitValue(num, 1));
		assertEquals(1, BitOperations.getBitValue(num, 2));
		assertEquals(-1, BitOperations.getBitValue(num, 100));
		assertEquals(-1, BitOperations.getBitValue(num, -2));
		
		
	}
	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; //0011_1010_1011_0111_1111_0101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
		assertEquals(0x2ab7f5, BitOperations.setBitValue(number, 20, false));
		assertEquals(0x1ab7f5, BitOperations.setBitValue(number, 21, false));
	}
	@Test
	@Disabled
	void revertBitValueTest() {
		long number = 0x3ab7f5; //001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(number, 5));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(number, 0));
		number = -1;
		
		assertEquals(1, BitOperations.getBitValue(number, 63));
		number = BitOperations.invertBitValue(number, 63);
		assertEquals(0, BitOperations.getBitValue(number, 63));
	}
	@Test
	void digitsNumberTest() {
		//TODO
	}
	@Test
	void leadingZerosTest() {
		//TODO
	}
	 @Test
	 @Disabled
	 void isHappyNumberTest() {
		 int expectedTrue = 123321;
		 int expectedFalse = 123467;
		 assertTrue( Numbers.isHappyNumber(expectedTrue));
		 assertFalse( Numbers.isHappyNumber(expectedFalse));
	 }
	 @Test
	 @Disabled
	 void getDigitsTest() {
		 int expected[] = {1, 2, 3, 4};
		 assertArrayEquals(expected, Numbers.getDigits(1234));
	 }
	 @Test
	 @Disabled
	 void getNumberFromDigitsTest() {
		 int expectedNumber = 1234;
		
		 assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[]{1, 2, 3, 4}));
	 }
	 @Test
	 void bibarySearchTest() {
		 int ar[] = {1,1,1,2,2,2,2,2,2,2,2,2,2,4,20,40};
		 assertEquals(-14, MyArrays.binarySearch(ar, 3));
		 assertEquals(3, MyArrays.binarySearch(ar, 2));
		 assertEquals(-1, MyArrays.binarySearch(ar, 0));
		 assertEquals(0, MyArrays.binarySearch(ar, 1));
		 assertEquals(-16, MyArrays.binarySearch(ar, 25));
		 assertEquals(-17, MyArrays.binarySearch(ar, 45));
	 }

}
