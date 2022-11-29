package telran.digital.numbers;

public class DigitalNumbersPrinting {
private static final String SYMBOL = "*";
public static void displayDigitalNumber(int number, int offset, int width, int height) {
	//TODO
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
public static  void displayStrings(String[] strings) {
	for(int i = 0; i < strings.length; i++) {
		System.out.println(strings[i]);
	}
	
}
}
