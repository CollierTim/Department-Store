import java.sql.*;
import java.util.Scanner;

public class EmployeeAccount extends Account{

    //Fields
    private int employeeNumber;

    //Constructor
    public EmployeeAccount(String firstName, String lastName, String userName, String password, int employeeNumber) {
        super(firstName, lastName, userName, password);
        this.employeeNumber = employeeNumber;
    }

    //Getter and Setter
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    //checks whether the current fields are in the database
    public boolean checkLoginCredentials() {
        boolean baseCredentials = super.checkLoginCredentials("employeeaccounts");
        boolean correctLogin = false;
        Connection connection;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/accounts",
                    "root",
                    "SoSweet86371"
            );
            Statement statement = connection.createStatement();
            int index = super.getCredentialsIndex();
            int employeeNumber = 0;
            ResultSet rs = statement.executeQuery("SELECT*FROM employeeaccounts WHERE `identifier` = " + index);
            while(rs.next()){
                employeeNumber = rs.getInt(6);
            }
            if(baseCredentials && this.employeeNumber == employeeNumber){
                correctLogin = true;
            }
        }catch(SQLException e){
            System.out.println("Error Exception 2");
            }
        return correctLogin;
    }

    //has the user set their login information
    public void inputLogin(Scanner user){
        super.inputLogin(user);

        System.out.print("Employee Number: ");
        setEmployeeNumber(user.nextInt());
        System.out.println();
    }
}
