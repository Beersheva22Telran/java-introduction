package telran.text;

public class Strings {
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return true if str2 is an anagram of str1 complexity O[N] two passes only
	 *         one additional array only symbols or English letters 1. the same
	 *         length 2. the same symbols just in different order
	 */
	public static boolean isAnagram(String str1, String str2) {
		boolean res = false;
		if (str1.length() == str2.length()) {
			int helper[] = new int[Byte.MAX_VALUE];
			res = true;
			fillHelper(helper, str1);
			int index = 0;
			int length = str2.length();
			while (index < length && res) {
				int indSymb = str2.charAt(index);
				if (helper[indSymb] == 0) {
					res = false;
				} else {
					helper[indSymb]--;
					index++;
				}
			}
		}
		return res;

	}

	private static void fillHelper(int[] helper, String str1) {
		int length = str1.length();
		for (int i = 0; i < length; i++) {
			int ind = str1.charAt(i);
			helper[ind]++;
		}

	}

	public static void sortStringNumbers(String[] array) {
		int offset = Byte.MAX_VALUE + 1;
		int helper[] = new int[offset * 2];
		fillHelper(helper, array, offset);
		sortFromHelper(array, helper, offset);
	}

	private static void sortFromHelper(String[] array, int[] helper, int offset) {
		int arrayInd = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[i]; j++) {
				array[arrayInd++] = getStringNumberFromIndex(i, offset);
			}
		}

	}

	private static String getStringNumberFromIndex(int index, int offset) {
		int number = index - offset;

		return Integer.toString(number);
	}

	private static void fillHelper(int[] helper, String[] array, int offset) {
		for (int i = 0; i < array.length; i++) {
			int index = getIndexFromStringNumber(array[i], offset);
			helper[index]++;
		}

	}

	private static int getIndexFromStringNumber(String string, int offset) {
		int number = Integer.parseInt(string);
		return number + offset;
	}

	public static String javaNameExp() {

		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}

	public static String ipV4Octet() {

		return "([01]?\\d\\d?|2([0-4]\\d|5[0-5]))";
	}

	public static String ipV4() {
		String octetExp = ipV4Octet();
		return String.format("(%1$s\\.){3}%1$s", octetExp);
	}

	private static String arithmeticExpression() {
		String operatorExp = operator();
		String operandExp = operand();
		// FIXME
		// adds checking right placing the braces

		return String.format("%1$s(%2$s%1$s)*", operandExp, operatorExp);
	}

	private static String operand() {
		// FIXME
		// adds possibility of using Java variables
		return "(\\d+\\.?\\d*|\\.\\d+)";
	}

	public static boolean isArithmeticExpression(String expression) {
		expression = expression.replaceAll("\\s+", "");
		return expression.matches(arithmeticExpression());
	}

	private static String operator() {

		return "([-+*/])";
	}

	/**
	 * 
	 * @param expression
	 * @param values
	 * @param namesSorted - variable names sorted
	 * @return computed value of a given expression or Double.NaN
	 */
	public static Double computeArithmenticExpression(String expression, double values[], String names[]) {
		// 10 (* 2)
		// 10 * 2(())
		Double res = Double.NaN;
		if (isArithmeticExpression(expression) && checkBraces(expression)) {
			expression = expression.replaceAll("[\\s()]+", "");
			String operands[] = expression.split(operator());
			String operators[] = expression.split(operand());
			res = getOperandValue(operands[0], values, names);
			int index = 1;
			while (index < operands.length && !res.isNaN()) {
				double operandValue = getOperandValue(operands[index], values, names);
				res = computeOperation(res, operandValue, operators[index]);
				index++;
			}
			
		}

		return res;
	}

	private static Double computeOperation(Double operand1, double operand2, String operator) {
		Double res = Double.NaN;
		if(!Double.isNaN(operand2)) {
			switch(operator) {
			case "+": res = operand1 + operand2; break;
			case "-": res = operand1 - operand2; break;
			case "*": res = operand1 * operand2; break;
			case "/": res = operand1 / operand2; break;
			default: res = Double.NaN;
			}
		}
		return res;
	}

	private static Double getOperandValue(String operand, double[] values, String[] names) {
		// FIXME for possible variable names
		return Double.parseDouble(operand);
	}

	public static boolean checkBraces(String expression) {
		// TODO
		return true;
	}

}
