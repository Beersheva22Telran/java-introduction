package telran.digital.numbers;

public class DigitalNumbersPrinting {
private static final String SYMBOL = "*";
private static final int MARGIN = 3;
public static void displayDigitalNumber(int number, int offset, int width, int height) {
	String strings[] = digitalNumber(number, offset, width, height);
	displayStrings(strings);
}
public static String line(int offset, int length) {
	return " ".repeat(offset) + SYMBOL.repeat(length);
}
public static String[] verticalLine(int offset, int height) {
	String [] res = new String[height];
	for (int i = 0; i < res.length; i++) {
		res[i] = " ".repeat(offset) + SYMBOL;
	}
	return res;
}
public static String[] twoVerticalLines(int offset, int width, int height) {
	String [] res = new String[height];
	for (int i = 0; i < res.length; i++) {
		res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
	}
	return res;
}
public static String[] zero(int offset, int width, int height) {
	String [] res = new String[height];
	res[0] = line(offset, width);
	String [] lines = twoVerticalLines(offset, width, height - 2);
	System.arraycopy(lines, 0, res, 1, lines.length);
	res[height - 1] = line(offset, width);
	return res;
}
public static String [] one(int offset, int width, int height) {
	return verticalLine(offset + width - 1, height);
}
public static String [] eight (int offset, int width, int height) {
	String [] res = zero(offset, width, height);
	int heightPart = heightPart(height);
	res[heightPart] = line(offset, width);
	return res;
	
}
public static String [] two (int offset, int width, int height) {
	String res[] = eight(offset, width, height);
	int heightPart = heightPart(height);
	cleanLinePart(res, offset, 1, heightPart);
	cleanLinePart(res, offset + width - 1, heightPart + 1, height - 1 );
	return res;
}
public static String [] five (int offset, int width, int height) {
	String res[] = eight(offset, width, height);
	int heightPart = heightPart(height);
	cleanLinePart(res, offset + width - 1, 1, heightPart);
	cleanLinePart(res, offset , heightPart + 1, height - 1 );
	return res;
}
public static String [] nine (int offset, int width, int height) {
	String res[] = eight(offset, width, height);
	int heightPart = heightPart(height);
	cleanLinePart(res, offset , heightPart + 1, height - 1 );
	return res;
}
public static String [] six (int offset, int width, int height) {
	String res[] = eight(offset, width, height);
	int heightPart = heightPart(height);
	cleanLinePart(res, offset + width - 1, 1, heightPart);
	
	return res;
}
public static String [] seven (int offset, int width, int height) {
	String res[] = one(offset, width,height);
	res[0] = line(offset,width);
	return res;
}

public static String[] three(int offset, int width, int height) {
	String res[] = eight(offset, width, height);
	int heightPart = heightPart(height);
	cleanLinePart(res, offset, 1, heightPart);
	cleanLinePart(res, offset, heightPart + 1, height - 1 );
	return res;
}
public static String[] four(int offset, int width, int height) {
	String res[] = twoVerticalLines(offset, width, height);
	int heightPart = heightPart(height);
	res[heightPart] = line(offset, width);
	cleanLinePart(res, offset, heightPart + 1, height  );
	return res;
}
public static  void displayStrings(String[] strings) {
	for(int i = 0; i < strings.length; i++) {
		System.out.println(strings[i]);
	}
	
}
private static void mergingLines(int indexFrom, String[] result, String[] lines) {
	System.arraycopy(lines, 0, result, indexFrom, lines.length);
	
}
private static int heightPart(int height) {
	int delta = height % 2 == 0 ? 1 : 0;
	int heightPart = height / 2 - delta;
	return heightPart;
}
private static void cleanLinePart(String line[], int position, int indexFrom, int height) {
	
	for (int i = indexFrom; i < height; i++) {
		char[] arLine = line[i].toCharArray();
		arLine[position] = ' ';
		line[i] = new String(arLine);
	}
}
static public String[] digitalNumber(int number, int offset, int width, int height) {
	int digits[] = getDigits(number);
	String[]result = getArrayDigit(digits[0], offset, width, height);
	for(int i = 1; i < digits.length; i++) {
		result = joinArrays(result, getArrayDigit(digits[i], MARGIN, width, height));
	}
	return result;
}
private static int[] getDigits(int number) {
	int numberLength = getNumberLength(number);
	int result[] = new int[numberLength];
	for(int i = numberLength - 1; i >= 0 ; i--) {
		result[i] = number % 10;
		number /= 10;
	}
	
	return result;
}
private static int getNumberLength(int number) {
	int count = 0;
	do {
		number /= 10;
		count++;
	} while(number != 0);
	return count;
}
private static String[] getArrayDigit(int digit, int offset, int width, int height) {
	switch(digit) {
	case 0: return zero(offset, width, height);
	case 1: return one(offset, width, height);
	case 2: return two(offset, width, height);
	case 3: return three(offset, width, height);
	case 4: return four(offset, width, height);
	case 5: return five(offset, width, height);
	case 6: return six(offset, width, height);
	case 7: return seven(offset, width, height);
	case 8: return eight(offset, width, height);
	case 9: return nine(offset, width, height);
	}
	return null;
}
private static String[] joinArrays(String[] array1, String[] array2) {
	String result[] = new String[array1.length];
	for (int i = 0; i < result.length; i++) {
		result[i] = array1[i] + array2[i];
	}
	return result;
}

}
