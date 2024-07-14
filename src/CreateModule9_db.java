import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateModule9_db {
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        createDatabase();
        checkNetBeansInstallation();
    }

    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE DATABASE IF NOT EXISTS databasedb";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating the database: " + e.getMessage());
        }
    }

    public static void checkNetBeansInstallation() {
        try {
            // Trying to run the NetBeans CLI command which would only run if NetBeans is installed
            Process process = Runtime.getRuntime().exec("netbeans --version");
            if (process.waitFor() == 0) {
                System.out.println("NetBeans is installed.");
            } else {
                System.out.println("NetBeans is not installed.");
            }
        } catch (Exception e) {
            System.out.println("Error checking NetBeans installation: " + e.getMessage());
        }
    }
}