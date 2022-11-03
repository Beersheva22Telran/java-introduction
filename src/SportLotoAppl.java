
public class SportLotoAppl {

	/**
	 * Application displays out 6 random numbers from 1 to 49 inclusive
	 * numbers can not be repeated in a sequence of 6 random numbers
	 * no additional collections / arrays
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("" + 100 + " " + 200);
		for (int i = 0; i < 6; i++) {
			System.out.print(getRandomInt(1, 49) + " ");
		}
		

	}
	public static int getRandomInt(int min, int max) {
		return (int)(min + Math.random() * (max - min + 1));
	}

}
