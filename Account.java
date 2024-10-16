import java.sql.*;
import java.util.Scanner;

//general account class will be superclass for other account types
public class Account {

    //Fields
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int credentialsIndex;

    //Constructor
    public Account(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.credentialsIndex = 0;
    }

    //Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getCredentialsIndex() {
        return credentialsIndex;
    }

    public void setCredentialsIndex(int credentialsIndex) {
        this.credentialsIndex = credentialsIndex;
    }

    //login
    public boolean checkLoginCredentials(String table){ //database is going to be which table(employee, admin)
        boolean userDetails = false;
        int index = 0;
        Connection connection;
        try{
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/accounts",
                    "root",
                    "SoSweet86371"
            );
            Statement statement = connection.createStatement();

            //finds the index of the last line in the database
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " +  table + " WHERE identifier=(SELECT max(identifier) FROM " + table + " )");
            while(resultSet.next()) {
                index = resultSet.getInt(1);
            }
            //cycles through database to check whether the login works
            for(int i = 1; i <= index; i++) {
                ResultSet rs = statement.executeQuery("SELECT * FROM " + table + " WHERE `identifier` = " + i); //identifier gives us the specific row

                //if one of these fails or these never exist together we know the user doesn't have their details in system.
                String firstname = "";
                String lastname = "";
                String username = "";
                String password = "";
                while(rs.next()) {
                    this.credentialsIndex = rs.getInt(1);
                    firstname = rs.getString(2); //2 represents the column
                    lastname = rs.getString(3);
                    username = rs.getString(4);
                    password = rs.getString(5);
                }

                //checks whether the user inputs are in the database
                if (this.firstName.equalsIgnoreCase(firstname)
                        && this.lastName.equalsIgnoreCase(lastname)
                        && this.userName.equals(username)
                        && this.password.equals(password)
                ) {
                    userDetails = true;
                    break;
                }
            }
        } catch(SQLException e){
            System.out.println("Error Exception 1");
        }
        return userDetails;
    }
    public void inputLogin(Scanner user){
        //takes in and sets the username to be checked
        //added a nextLine, so it wouldn't skip the username input.
        user.nextLine();
        System.out.print("Username: ");
        setUserName(user.nextLine());
        System.out.println();

        //takes in and sets firstname to check whether its in the database
        System.out.print("First Name: ");
        setFirstName(user.nextLine());
        System.out.println();

        System.out.print("Last Name: ");
        setLastName(user.nextLine());
        System.out.println();

        System.out.print("Password: ");
        setPassword(user.nextLine());
        System.out.println();
    }
}
