/*Created by Ryan Norrbom 
 * Created On: 06/09/2024
 * Created for: CSD420
 * 
 * Recursive method to compute the cum using computeSum. Includes test method. 
 * 
 */
public class NorrbomRyan_Module2 {

    // Recursive method to compute the sum
    public static double computeSum(int i) {
        if (i == 1) {
            return 1.0 / 2.0;  // Base case
        } else {
            return (double) i / (i + 1) + computeSum(i - 1);  // Recursive case
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] testValues = {4, 9, 14};

        for (int value : testValues) {
            double result = computeSum(value);
            System.out.printf("computeSum(%d) = %.6f%n", value, result);
        }
    }
}