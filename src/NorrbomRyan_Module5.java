/*Created by Ryan Norrbom 
 * Created On: 06/19/2024
 * Created for: CSD420
 * 
 * Java application will use Word API, Provided by https://random-word-api.herokuapp.com/home, to create a list of words. WIll prompt user for count of words, then creates the text file for collection of words. Once generated the code then sorts the words by ascending and descending order.
 * 
 */

 // Start
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NorrbomRyan_Module5 {

    // File name and API Info
    private static final String FILE_NAME = "collection_of_words.txt";
    private static final String API_URL = "https://random-word-api.herokuapp.com/word?number=";

    // Starting class, prompts user if they want to create the file
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Generate Words file? (yes/no): ");
        String response = scanner.nextLine();

        if ("yes".equalsIgnoreCase(response)) {
            System.out.print("Enter the number of words to create: ");
            int wordCount = scanner.nextInt();
            generateWords(wordCount);
        }

        displayWords();
    }
    // Generates words for the word file
    private static void generateWords(int wordCount) {
        try {
            URL url = new URL(API_URL + wordCount);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            String words = content.toString().replace("[", "").replace("]", "").replace("\"", "");
            String[] wordArray = words.split(",");

            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            for (String word : wordArray) {
                writer.write(word.trim());
                writer.newLine();
            }
            writer.close();
            System.out.println("Words have been written to " + FILE_NAME);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method for sorting the Array List. 
    private static void displayWords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            Set<String> wordSet = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                wordSet.add(line.trim());
            }
            reader.close();
            
            // Ascending Order
            Set<String> sortedWordsAsc = new TreeSet<>(wordSet);
            System.out.println("Words in ascending order:");
            for (String word : sortedWordsAsc) {
                System.out.println(word);
            }

            // Descending Order
            Set<String> sortedWordsDesc = new TreeSet<>((a, b) -> b.compareTo(a));
            sortedWordsDesc.addAll(wordSet);
            System.out.println("Words in descending order:");
            for (String word : sortedWordsDesc) {
                System.out.println(word);
            }

        // Error handle if text file cannot be read. 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//End