import java.util.*;
import java.io.*;


public class CountBinaryOnes {
	public static String convertToBinary(int dec) {
		StringBuilder s = new StringBuilder();
		while (dec > 0) {
			s.insert(0, dec % 2);
			dec = dec / 2;	
		}
		return s.toString();
	}

	public static void main(String args[]) {
		// Get decimal representation of number from stdout
		Scanner scan = new Scanner(System.in);
		int dec = scan.nextInt();
		scan.close();

		// Convert decimal rep to binary string rep
		String s = convertToBinary(dec);

		int maxOnes = 0;
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			if (1 == Character.getNumericValue(s.charAt(i))) {
				counter++;
				if (counter > maxOnes) {
					maxOnes = counter;
				}
			}
			else {
				counter = 0;
			}
		}

		System.out.println(maxOnes);
	}

}
