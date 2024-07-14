/*Created by Ryan Norrbom 
 * Created On: 06/01/2024
 * Created for: CSD420
 * 
 * Main Class to call Java files for each module in the Advanced Java Programming Class at Bellevue
 * 
 * Updated on July 14th 2024 to use a dropdown for selection.
 * 
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 
 public class MainGUI extends JFrame {
     public MainGUI() {
         super("Advanced Java Programming Class");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(400, 300);
         setLocationRelativeTo(null);  // Center the window
         setLayout(new BorderLayout());
 
         // Create Dropdown Menu for Modules
         String[] options = {
             "Exit",
             "Module 1: Write data to file",
             "Module 1: Read data from file",
             "Module 2: Recursion",
             "Module 3: Array Lists",
             "Module 4",
             "Module 5",
             "Module 6",
             "Module 7",
             "Module 8: RyanThreeThreads",
             "Module 10: Fan Information System"
         };
 
         JComboBox<String> comboBox = new JComboBox<>(options);
         add(comboBox, BorderLayout.NORTH);
 
         JButton selectButton = new JButton("Select");
         add(selectButton, BorderLayout.SOUTH);
 
         selectButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 int choice = comboBox.getSelectedIndex();
                 switch (choice) {
                     case 0:
                         System.exit(0);
                         break;
                     case 1:
                         NorrbomRyan_Module1_Write.writeData();
                         break;
                     case 2:
                         NorrbomRyan_Module1_Read.readData();
                         break;
                     case 3:
                         NorrbomRyan_Module2.main(null);
                         break;
                     case 4:
                         NorrbomRyan_Module3.main(null);
                         break;
                     case 5:
                         NorrbomRyan_Module4.main(null);
                         break;
                     case 6:
                         NorrbomRyan_Module5.main(null);
                         break;
                     case 7:
                         NorrbomRyan_Module6.main(null);
                         break;
                     case 8:
                         NorrbomRyan_Module7.main(null);
                         break;
                     case 9:
                         RyanThreeThreads.main(null);
                         break;
                     case 10:
                         NorrbomRyan_Module10.main(null);
                         break;
                     default:
                         JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                         break;
                 }
             }
         });
 
         setVisible(true);
     }
 
     public static void main(String[] args) {
         new MainGUI();
     }
 }