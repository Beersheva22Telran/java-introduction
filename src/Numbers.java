
public class Numbers {
	public static final int N_HAPPY_NUMBER_DIGITS = 6;

	static public int getNdigits(long number) {
		int res = 0;
		do {
			number /= 10;
			res++;
		} while (number != 0);
		return res;
	}

	/**
	 * 
	 * @param number
	 * @return true only if number comprises of 6 digits and sum of first three
	 *         digits equals the sum of last three digits
	 */
	static public boolean isHappyNumber(int number) {
		boolean res = false;
		number = Math.abs(number);
		if (getNdigits(number) == N_HAPPY_NUMBER_DIGITS) {
			int halfDigits = N_HAPPY_NUMBER_DIGITS / 2;
			int numberPartDivider = (int) Math.pow(10, halfDigits);
			int sumFirstPart = getSumDigits(number / numberPartDivider);
			res = sumFirstPart == getSumDigits(number % numberPartDivider);

		}
		return res;
	}

	private static int getSumDigits(int number) {
		int res = 0;
		do {
			res += number % 10;
			number /= 10;
		} while (number != 0);
		return res;
	}
	public static int[] getDigits(int number) {
		int res[] = new int[getNdigits(number)];
		for(int i = res.length - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}
	public static int getNumberFromDigits(int[] digits) {
		int res = 0;
		for(int i = 0; i < digits.length; i++) {
			res = res * 10 + digits[i];
		}
		return res;
	}
	public static long getRandomNumber(long min, long max) {
		return (long) (min + Math.random() * (max - min + 1));
	}
}
