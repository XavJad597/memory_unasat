import java.sql.*;
import java.util.Scanner;


public class Profile {
    public static void main(String[] args) throws ClassNotFoundException {

        // for the input of the names u put in it


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");

        System.out.println("Do you want to:");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

          if(choice == 1) {
              System.out.print("Enter your name: ");
              String name = scanner.nextLine();
              System.out.print("Enter your birthdate:   ");
              String birthDate = scanner.nextLine();
              System.out.print("Enter your username:   ");
              String userName = scanner.nextLine();
              System.out.print("Enter your password:   ");
              String userPassword = scanner.nextLine();

              //log in to your database
              String url = "jdbc:mysql://localhost:3306/memoryg";
              String username = "root";
              String password = "Hotwheels2016";

              //making the query for the name collumn with a parameterized query
              String insertDataQuery = "INSERT INTO player (player_name,birth_date,username,p_password) VALUES (?,?,?,?)";
              String getQuery = "SELECT * FROM user_details";
              Connection connection = null;

              try {
                  // Step 1: Load the MySQL JDBC driver
                  Class.forName("com.mysql.cj.jdbc.Driver");

                  // Step 2: Establish the connection
                  connection = DriverManager.getConnection(url, username, password);

                  // Step 3: Execute the query
                  PreparedStatement statement = connection.prepareStatement(insertDataQuery);
                  statement.setString(1, name);
                  statement.setString(2, birthDate);
                  statement.setString(3, userName);
                  statement.setString(4, userPassword);
                  statement.executeUpdate();
              } catch (SQLException e) {
                  System.out.println("Error: Required class not found.");
                  e.printStackTrace();
              } finally {
                  // Step 4: Close the connection
                  if (connection != null) {
                      try {
                          connection.close();
                      } catch (SQLException e) {
                          System.out.println("Error: Failed to close the connection.");
                          e.printStackTrace();
                      }
                  }
              }
              System.out.println("signed in!!");
              } else if (choice == 2 ) {  System.out.println("Log in");

            System.out.print("Enter your username: ");
            String userName = scanner.nextLine();
            System.out.print("Enter your password: ");
            String userPassword = scanner.nextLine();

            String url = "jdbc:mysql://localhost:3306/memoryg";
            String username = "root";
            String password = "Hotwheels2016";

            LoginManager loginManager = new LoginManager(url, username, password);
            boolean loginSuccess = loginManager.login(userName, userPassword);

            if (loginSuccess) {
                System.out.println("Logged in successfully!");

                while (true) {
                    System.out.println("Menu:");
                    System.out.println("1. Update Profile");
                    System.out.println("2. Log out");
                    System.out.print("Enter your choice: ");
                    int menuChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading the integer

                    if (menuChoice == 1) {
                        // Update profile process
                        System.out.println("Update profile?");
                        System.out.print("Enter your new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter your new birthdate: ");
                        String newBirthDate = scanner.nextLine();
                        System.out.print("Enter your new password: ");
                        String newPassword = scanner.nextLine();

                        UpdateManager updateManager = new UpdateManager(url, username, password);
                        boolean succesUpdate = updateManager.updateProfile(userName, newName, newBirthDate, newPassword);

                         if(succesUpdate) {
                          System.out.println("Profile updated ");
                         }
                         else{
                             System.out.println("Profile update failed. Try again");
                         }

                    } else if (menuChoice == 2){
                    System.out.println("logged out");
                    }
                }




                // Continue with the rest of your program logic for a successful login
            } else {
                System.out.println("Invalid username or password. Login failed!");
                // Handle login failure case as per your requirements
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
}


// class to handle the login functionality
class LoginManager {
    private String url;
    private String username;
    private String password;

    public LoginManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean login(String userName, String userPassword) {
        // extracts the users info with paramaterized values
        String selectQuery = "SELECT * FROM player WHERE username = ? AND p_password = ?";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            PreparedStatement loginStatement = connection.prepareStatement(selectQuery);
            loginStatement.setString(1, userName);
            loginStatement.setString(2, userPassword);

            ResultSet resultSet = loginStatement.executeQuery();
            if (resultSet.next()) {
                // User exists and credentials are correct
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Required class not found.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error: Failed to close the connection.");
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
}

 class UpdateManager {
    private String url;
    private String username;
    private String password;

    public UpdateManager(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean updateProfile(String userName, String newName, String newBirthDate, String newPassword) {
        String updateQuery = "UPDATE player SET  p_password = ? WHERE username = ?";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(3, newPassword);
            updateStatement.setString(4, userName);

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Required class not found.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error: Failed to close the connection.");
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
}