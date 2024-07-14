/*Created by Ryan Norrbom 
 * Created On: 07/14/2024
 * Created for: CSD420
 * 
 * Uses the DB created using MySQL to run a fan class. 
 * 
 * 
 * 
 * CREATE DATABASE IF NOT EXISTS databasedb;
 * USE databasedb;
 * CREATE TABLE IF NOT EXISTS fans (
    ID INT PRIMARY KEY,
    firstname VARCHAR(25),
    lastname VARCHAR(25),
    favoriteteam VARCHAR(25)
);

-- Example data
INSERT INTO fans (ID, firstname, lastname, favoriteteam) VALUES (1, 'Ryan', 'Norrbom', 'Seahawks');
INSERT INTO fans (ID, firstname, lastname, favoriteteam) VALUES (2, 'Brandy', 'Norrbom', 'Trailblazers');
 * 
 */


// Start
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class NorrbomRyan_Module10 extends JFrame {
    private JTextField IdField, FirstNameField, LastNameField, FavoriteTeamField;
    private JButton DisplayButton, UpdateButton;
    private Connection db; // Database connection

    public NorrbomRyan_Module10() {
        super("Fan Information System");
        ConnectDatabase();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(5, 2));

        // Setup text fields
        IdField = new JTextField();
        FirstNameField = new JTextField();
        LastNameField = new JTextField();
        FavoriteTeamField = new JTextField();
        
        // Setup buttons
        DisplayButton = new JButton("Display");
        UpdateButton = new JButton("Update");
        
        // Register action listeners for buttons
        DisplayButton.addActionListener(this::DisplayRecord);
        UpdateButton.addActionListener(this::UpdateRecord);

        // Add components to frame
        add(new JLabel("ID:"));
        add(IdField);
        add(new JLabel("First Name:"));
        add(FirstNameField);
        add(new JLabel("Last Name:"));
        add(LastNameField);
        add(new JLabel("Favorite Team:"));
        add(FavoriteTeamField);
        add(DisplayButton);
        add(UpdateButton);

        setVisible(true);
    }

    private void ConnectDatabase() {
        try {
            db = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/databasedb", "student1", "pass"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection error: " + e.getMessage());
        }
    }

    private void DisplayRecord(ActionEvent event) {
        int id = Integer.parseInt(IdField.getText().trim());
        try (PreparedStatement stmt = db.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                FirstNameField.setText(rs.getString("firstname"));
                LastNameField.setText(rs.getString("lastname"));
                FavoriteTeamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching record: " + e.getMessage());
        }
    }

    private void UpdateRecord(ActionEvent event) {
        int id = Integer.parseInt(IdField.getText().trim());
        String firstName = FirstNameField.getText().trim();
        String lastName = LastNameField.getText().trim();
        String favoriteTeam = FavoriteTeamField.getText().trim();

        try (PreparedStatement stmt = db.prepareStatement(
            "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?")) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, favoriteTeam);
            stmt.setInt(4, id);
            int affected = stmt.executeUpdate();
            if (affected == 1) {
                JOptionPane.showMessageDialog(this, "Record updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Error updating record");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating record: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new NorrbomRyan_Module10();
    }
}

// End