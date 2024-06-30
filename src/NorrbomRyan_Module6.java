/*Created by Ryan Norrbom 
 * Created On: 06/27/2024
 * Created for: CSD420
 * 
 * Creates two arrays, one integer and the other String for use as test cases. One test is for Comparator and the other for Comparable interfaces before and after using Bubble sort. 
 * 
 */

 // Start
 import java.util.Comparator;

 public class NorrbomRyan_Module6 {
 
     // bubble sort using Comparable interface
     public static <E extends Comparable<E>> void bubbleSort(E[] list) {
         boolean swapped;
         for (int i = 0; i < list.length - 1; i++) {
             swapped = false;
             for (int j = 0; j < list.length - 1 - i; j++) {
                 if (list[j].compareTo(list[j + 1]) > 0) {
                     // Swap list[j] and list[j + 1]
                     E temp = list[j];
                     list[j] = list[j + 1];
                     list[j + 1] = temp;
                     swapped = true;
                 }
             }
             // If none, break the loop
             if (!swapped) {
                 break;
             }
         }
     }
 
     // bubble sort method using Comparator interface
     public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
         boolean swapped;
         for (int i = 0; i < list.length - 1; i++) {
             swapped = false;
             for (int j = 0; j < list.length - 1 - i; j++) {
                 if (comparator.compare(list[j], list[j + 1]) > 0) {
                     // Swap list[j] and list[j + 1]
                     E temp = list[j];
                     list[j] = list[j + 1];
                     list[j + 1] = temp;
                     swapped = true;
                 }
             }
             // If none, break the loop
             if (!swapped) {
                 break;
             }
         }
     }
 
     // Test code 
     public static void main(String[] args) {
         // Test the bubble sort using Comparable
         Integer[] intArray = {5, 17, 34, 3, 1};
         System.out.println("Original array:");
         printArray(intArray);
         bubbleSort(intArray);
         System.out.println("Sorted array w/ Comparable:");
         printArray(intArray);
 
         // Test the bubble sort using Comparator
         String[] stringArray = {"dog", "cat", "fox", "eagle"};
         System.out.println("\nOriginal array:");
         printArray(stringArray);
         bubbleSort(stringArray, new Comparator<String>() {
             @Override
             public int compare(String s1, String s2) {
                 return s1.compareTo(s2);
             }
         });
         System.out.println("Sorted array w/ Comparator:");
         printArray(stringArray);
     }
 
     // used to print arrays to the console
     public static <E> void printArray(E[] array) {
         for (E element : array) {
             System.out.print(element + " ");
         }
         System.out.println();
     }
 }
//End