/*Created by Ryan Norrbom 
 * Created On: 06/15/2024
 * Created for: CSD420
 * 
 * Java application that uses a test size of 50k and 500k 
 * 
 */

 // Start
 import java.util.Iterator;
 import java.util.LinkedList;
 
 public class NorrbomRyan_Module4 {
     
     public static void main(String[] args) {
         System.out.println("Starting Test (Please wait for 'End of Tests'):"); // Identifies the start of the code to user
         int testSize1 = 50000;
         int testSize2 = 100000;
         int testSize3 = 500000;
         
         // Test with 50,000 integers takes about 2 seconds to run
         LinkedList<Integer> list1 = new LinkedList<>();
         for (int i = 0; i < testSize1; i++) {
             list1.add(i);
         }
         usingIterator(list1);
         usingGet(list1);

        // Test with 100,000 integers takes about 40 seconds to run
         LinkedList<Integer> list2 = new LinkedList<>();
         for (int i = 0; i < testSize2; i++) {
             list2.add(i);
         }
         usingIterator(list2);
         usingGet(list2);
         
         // Test with 500,000 numbers Takes about 2 Minutes to run
         LinkedList<Integer> list3 = new LinkedList<>();
         for (int i = 0; i < testSize3; i++) {
             list3.add(i);
         }
         usingIterator(list3);
         usingGet(list3);
         System.out.println("End of Tests"); // Shows end of test, since there is a significant delay for 500k integers. 
     }
    // Iterator Method
     private static void usingIterator(LinkedList<Integer> list) {
         long startTime = System.currentTimeMillis();
         Iterator<Integer> iterator = list.iterator();
         while (iterator.hasNext()) {
             iterator.next();
         }
         // Use the System to track in Milliseconds
         long endTime = System.currentTimeMillis();
         System.out.println("Using Iterator took: " + (endTime - startTime) + " ms for list size: " + list.size());
     }
    // get Method
     private static void usingGet(LinkedList<Integer> list) {
         long startTime = System.currentTimeMillis();
         for (int i = 0; i < list.size(); i++) {
             list.get(i);
         }
        // Use the System to track in Milliseconds
         long endTime = System.currentTimeMillis();
         System.out.println("Using get(index) took: " + (endTime - startTime) + " ms for list size: " + list.size());
     }
 }
 
 // End