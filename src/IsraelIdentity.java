
public class IsraelIdentity {
	private static final int N_DIGITS_ID = 9;

	/**
	 * 
	 * @param id
	 * @return true for right id otherwise false number control sum should be
	 *         multiple of 10 ( sum % 10 == 0) for even indexes (0, 2, 4, 6, 8)
	 *         digits as is for odd indexes (1, 3, 5, 9) digit = digit * 2, if > 9
	 *         the sum of inner digits is taken example, 123456782 => 1 + 4(2 * 2) +
	 *         3 + 8(4 * 2) +5 + 3 (6 * 2 = 12 => 1 + 2) + 7 + 7 (8 * 2=16=>1 + 6) +
	 *         2
	 */
	public static boolean verify(int id) {
		boolean res = false;
		if (id > 0) {
			int digits[] = Numbers.getDigits(id);
			if (N_DIGITS_ID == digits.length) {
				int controlSum = getControlSum(digits);
				res = controlSum % 10 == 0;
			}
			
		}
		return res;

	}

	private static int getControlSum(int[] digits) {
		
		return sumEvenIndexes(digits) + sumOddIndexes(digits);
	}

	private static int sumOddIndexes(int[] digits) {
		int res = 0;
		for(int i = 1; i < digits.length; i += 2) {
			int digit = digits[i] * 2;
			if (digit > 9) {
				digit -= 9;
			}
			res += digit;
		}
		return res;
	}

	private static int sumEvenIndexes(int[] digits) {
		int res = 0;
		for (int i = 0; i < digits.length; i += 2) {
			res += digits[i];
		}
		return res;
	}

	/**
	 * 
	 * @return random number of 9 digits matching right Israel id cycle not more
	 *         than 9 iterations
	 */
	public static int generateRandomId() {
		int digits[] = new int[N_DIGITS_ID - 1];
		fillRandomDigits(digits);
		int controlSum = getControlSum(digits);
		int lastDigit = getLastDigit(controlSum) ;
		int res = Numbers.getNumberFromDigits(digits);
		res = res * 10 + lastDigit;
		
		return res;
	}

	private static int getLastDigit(int controlSum) {
		int rem = controlSum % 10;
		int res = 0;
		if(rem != 0) {
			res = 10 - rem;
		}
		return res;
		
	}

	private static void fillRandomDigits(int[] digits) {
		digits[0] = (int) Numbers.getRandomNumber(1, 9);
		for(int i = 1; i < digits.length; i++) {
			digits[i] = (int) Numbers.getRandomNumber(0, 9);
		}
		
	}
}
