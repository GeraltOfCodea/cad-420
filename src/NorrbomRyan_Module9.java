/*Created by Ryan Norrbom 
 * Created On: 07/13/2024
 * Created for: CSD420
 * 
 * Tests that the database connection works. Included items in this module were the 9Examples created by the professor. DB is created using the CreateModule9_db class. 
 * 
 */

 // Start
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NorrbomRyan_Module9 {
    private static final String URL = "jdbc:mysql://localhost/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        // Establish connection
        try (Connection db_conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection established successfully!");
            
            // Test commands can be executed here
            try (Statement stmt = db_conn.createStatement()) {
                // Example: Create a table, insert data, select data, etc.
                String sql = "CREATE TABLE test_table(id INT PRIMARY KEY, name VARCHAR(50))";
                stmt.executeUpdate(sql);
                System.out.println("Table created successfully!");

                // Insert data
                sql = "INSERT INTO test_table VALUES (1, 'Test User')";
                stmt.executeUpdate(sql);
                System.out.println("Data inserted successfully!");
            } catch (SQLException e) {
                System.out.println("Error executing database operations: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}