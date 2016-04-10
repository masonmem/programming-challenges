import java.io.*;
import java.util.*;

public class CountHourglass {

	public static final int MATRIX_SIZE = 6;

	public static void main(String args[]) {
		// Read in matrix from stdout
		int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}

		// Calculate max hourglass sum. We will traverse over every point
        // that lets us form an hourglass in bounds, hence MATRIX_SIZE - 2
		int maxSum = 0;
		for (int i = 0; i < MATRIX_SIZE - 2; i++) {
			for (int j = 0; j < MATRIX_SIZE - 2; j++) {
				int sum = 0;
                
                // First row
				sum += matrix[i][j];
				sum += matrix[i][j+1];
				sum += matrix[i][j+2];
                
                // Second row
				sum += matrix[i+1][j+1];
                
                // Third row
				sum += matrix[i+2][j];
				sum += matrix[i+2][j+1];
				sum += matrix[i+2][j+2];
                
                if (i == 0 && j == 0) {
					maxSum = sum;
				}
				else if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		System.out.println(maxSum);
	}

}