/*Created by Ryan Norrbom 
 * Created On: 07/06/2024
 * Created for: CSD420
 * 
 * Program leverages three threads and selects between three character array options. One being standard alphabet, one inuteger, and the other special characters. The Test code runs over 10K passes on each thread. 
 * 
 */

// Start
import java.util.Random;
import java.util.Scanner;

public class RyanThreeThreads {

    private static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] NUMBERS = "0123456789".toCharArray();
    private static final char[] SYMBOLS = "!@#$%&*".toCharArray();

    public static void main(String[] args) {
        startCharacterGeneration();
    }

    public static void startCharacterGeneration() {
        Scanner scanner = new Scanner(System.in); // Java Project errors out from Main Class is I close Scanner. 
        final int[] count = new int[1];

        System.out.println("Enter the number of characters to display (>10,000): ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            count[0] = new Random().nextInt(990001) + 10000;
        } else {
            try {
                count[0] = Integer.parseInt(input);
                if (count[0] <= 10000) {
                    throw new IllegalArgumentException("Number must be greater than 10,000.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter an Integer that is >10,000.");
                System.exit(1);
            }
        }

        System.out.println("Generating " + count[0] + " characters...");

        Thread letterThread = new Thread(() -> generateCharacters(LETTERS, count[0]));
        Thread numberThread = new Thread(() -> generateCharacters(NUMBERS, count[0]));
        Thread symbolThread = new Thread(() -> generateCharacters(SYMBOLS, count[0]));

        letterThread.start();
        numberThread.start();
        symbolThread.start();

        try {
            letterThread.join();
            numberThread.join();
            symbolThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Character Creation completed.");
    }

    private static void generateCharacters(char[] charArray, int count) {
        Random random = new Random();
        StringBuilder output = new StringBuilder(count);

        for (int i = 0; i < count; i++) {
            output.append(charArray[random.nextInt(charArray.length)]);
        }

        // Display using a standard output.
        System.out.println(output.toString());
    }
}

// End