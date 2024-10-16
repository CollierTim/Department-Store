import java.sql.*;
import java.util.Scanner;
public class ShipmentAccount extends Account{
   //Fields
    private String companyName;
    private int companyNumber;

    //Constructor
    public ShipmentAccount(String firstName, String lastName, String userName, String password, String companyName, int companyNumber) {
        super(firstName, lastName, userName, password);
        this.companyName = companyName;
        this.companyNumber = companyNumber;
    }

    //Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }


    public boolean checkLoginCredentials() {
        boolean baseCredentials = super.checkLoginCredentials("shipperaccounts");
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
            String companyName = "";
            int companyNumber = 0;
            ResultSet rs = statement.executeQuery("SELECT*FROM shipperaccounts WHERE `identifier` = " + index);
            while(rs.next()){
                companyName = rs.getString(6);
                companyNumber = rs.getInt(7);
            }
            if(baseCredentials && this.companyName.equals(companyName)
              && this.companyNumber == companyNumber){
                correctLogin = true;
            }
        }catch(SQLException e){
            System.out.println("Error Exception 3");
        }
        return correctLogin;
    }
    //user inputs their login information to then be checked by checkLoginCredentials method to see whether it is in the database.
    public void inputLogin(Scanner user){
        super.inputLogin(user);
        System.out.print("Company Name: ");
        setCompanyName(user.nextLine());
        System.out.println();

        System.out.print("Company Number: ");
        setCompanyNumber(user.nextInt());
        System.out.println();
    }
    public void createAccount(){

    }

}
