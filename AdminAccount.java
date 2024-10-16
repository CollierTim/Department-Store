import java.sql.*;
import java.util.Scanner;

public class AdminAccount extends Account{

    //Fields
    private int adminNumber;

    //Constructor
    public AdminAccount(String firstName, String lastName, String userName, String password, int adminNumber) {
        super(firstName, lastName, userName, password);
        this.adminNumber = adminNumber;
    }

    //Getter and Setter
    public int getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(int adminNumber) {
        this.adminNumber = adminNumber;
    }


    public boolean checkLoginCredentials() {

        boolean baseCredentials = super.checkLoginCredentials("adminaccounts");
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
            int adminNumber = 0;
            ResultSet rs = statement.executeQuery("SELECT*FROM adminaccounts WHERE `identifier` = " + index);
            while(rs.next()){
                adminNumber = rs.getInt(6);
            }
            if(baseCredentials && this.adminNumber == adminNumber){
                correctLogin = true;
            }
        }catch(SQLException e){
            System.out.println("Error Exception 3");
        }
        return correctLogin;
    }

    public void inputLogin(Scanner user){
        super.inputLogin(user);

        System.out.println("Admin Number: ");
        setAdminNumber(user.nextInt());
        System.out.println();
    }
}
