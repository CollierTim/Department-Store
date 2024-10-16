import java.sql.*;
import java.util.Scanner;

public class CustomerAccount extends Account{
    public CustomerAccount(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
    }

    public boolean checkLoginCredentials() {
        return super.checkLoginCredentials("customeraccounts");
    }

    public void inputLogin(Scanner user){
        super.inputLogin(user);
    }
    }

