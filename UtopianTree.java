import java.io.*;
import java.util.*;

public class UtopianTree {

	// Initial height of tree in meters
	public final static int INITIAL_HEIGHT = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numCases = scan.nextInt();
		
		for (int testCase = 0; testCase < numCases; testCase++) {
			// Height of tree
			int height = INITIAL_HEIGHT;

			// Number of seasons
			int n = scan.nextInt();

			// Calculate full growth units (2 seasons, spring and summer)
			int numFullCycles = n / 2;
			boolean extraSpring = (n % 2 == 1) ? true : false;

			// Calculate full cycle growth
			if (numFullCycles > 0) {
				height = (int)Math.pow(2, numFullCycles) * INITIAL_HEIGHT + (int)Math.pow(2, numFullCycles) - 1;
			}
			// Add single spring's growth (2h)
			if (extraSpring) {
				height = 2 * height;
			}

			System.out.println(height);
		}
	}

}
