import java.io.*;
import java.util.*;

public class FindDigits {

	public static final int MIN_TESTCASES = 1;
	public static final int MAX_TESTCASES = 15;
	public static final int MIN_NUM = 0;
	public static final int MAX_NUM = 1000000000;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();

		if (testCases < MIN_TESTCASES || testCases > MAX_TESTCASES) {
			System.out.println("ERROR: Num test cases does not fit constraints");
		}

		for (int test = 0; test < testCases; test++) {
			int num = scan.nextInt();
			String sNum = Integer.toString(num);
			int numDivisible = 0;

			if (num < MIN_NUM || num > MAX_NUM) {
				System.out.println("ERROR: Number does not fit constraints");
			}

			for (int i = 0; i < sNum.length(); i++) {
				int digit = Character.getNumericValue(sNum.charAt(i));
				if ((digit != 0) && (num % digit == 0)) {
					numDivisible++;
				}
			}
			System.out.println(numDivisible);
		}
	}

}