import java.io.*;
import java.util.*;

public class Solution {
	public static final int MIN_TESTCASES = 1;
	public static final int MAX_TESTCASES = 20;
	public static final int MIN_NUM = 1;
	public static final int MAX_NUM = 100000;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int numTests = scan.nextInt();

		/* Check that num test cases fits constraint */
		if (numTests < MIN_TESTCASES || numTests > MAX_TESTCASES) {
			System.out.println("Invalid number of test cases");
			return;
		}

		for (int testcase = 0; testcase < numTests; testcase++) {
			StringBuilder s = new StringBuilder();
			int numDigits = scan.nextInt();
			
			/* Check that number of digits fits constraint */
			if (numDigits < MIN_NUM || numDigits > MAX_NUM) {
				System.out.println("Invalid number of digits");
				return;
			}

			/* Check for our best case scenario where num is
				divisible by 3 and can be composed of all 5s */
			if (numDigits % 3 == 0) {
				for (int i = 0; i < (numDigits/3); i++) {
					s.append("555");
				}
				System.out.println(s.toString());
			}
			/* We must try to pad to the right with as few 
				3s as possible to reduce num digits by 5 and
				make it disivisble by 3. */
			else {
				// The number of groups of 3 we have used.
				int groupsOf3 = 0;
				// Continue to reduce while we still have at least 5 digits
				while ((numDigits / 5) > 0 && s.toString().equals("")) {
					groupsOf3++;
					numDigits -= 5;
					// Now that we have reduced, check if divisible by 3 yet
					if (numDigits % 3 == 0) {
						// Criteria met. Now, generate string and print
						for (int i = 0; i < (numDigits / 3); i++) {
							s.append("555");   
						}
						for (int i = 0; i < groupsOf3; i++) {
							s.append("33333");
						}
						System.out.println(s.toString());
					}
				}
				// If we did not successfully reduce, decent number DNE
				if (s.toString().equals("")) {
					System.out.println("-1");
				}
			}
		}
	}
}