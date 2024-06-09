/*Created by Ryan Norrbom 
 * Created On: 06/08/2024
 * Created for: CSD420
 * 
 * Method that created an array  of 5 integers and displays them. Then, the array removes duplicates and displays the array without duplicates. Displays count of both arrays. 
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class NorrbomRyan_Module3 {
    
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        HashSet<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        // Create an ArrayList and fill it with 50 random values from 1 to 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Print the original list
        System.out.println("Original List: " + originalList);

        // Remove duplicates
        ArrayList<Integer> noDuplicatesList = removeDuplicates(originalList);

        // Print the list without duplicates
        System.out.println("List without duplicates: " + noDuplicatesList);

        // Test code to ensure the method works correctly
        System.out.println("Original list size: " + originalList.size());
        System.out.println("No duplicates list size: " + noDuplicatesList.size());
    }
}
