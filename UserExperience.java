import java.util.Scanner;

//holds all the user interactions and print statements so can be just called in main.
//ex methods: promptUser, promptAdmin, promptShipper, mainScreen etc...
public class UserExperience {

    //Fields
    private int userNumber;
    private String accountType;
    private final String[] accountTypes = {"customer", "shipment", "admin", "employee"};
    private boolean correctLogin;
    //Constructor
    public UserExperience(){
        this.userNumber = 0;
        this.accountType = "";
    }

    //Getter and Setter
    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public boolean getCorrectLogin(){
        return this.correctLogin;
    }

    public void setCorrectLogin(boolean correctLogin){
        this.correctLogin = correctLogin;
    }

    //prompts the user to log in or create an account
    public void greetingMessage(Scanner user){
        System.out.println("Welcome to the department store website" + "\n");
        System.out.println("Please enter account type: Customer, Employee, Admin, Shipment");

        //checks if the users input is in the list, if not tell them to try again
        this.accountType = user.nextLine();

        //loops user input until they have entered a correct account type
        while(checkAccountType(this.accountType) == false){
            System.out.println("Please enter a valid account type: ");
             this.accountType = user.nextLine();
        }
        //allows user to enter whether they want to log in or create an account
//        System.out.println("Login: Enter 1");
//        System.out.println("Create an account: Enter 2");
//            this.userNumber = user.nextInt();
    }
    //this is next, make it use inputLogin method to set the values and then use checkLoginCredentials method
    //
    //
    // to check whether their login information is correct and to log them in
    public void checkLogin(Scanner user){

        //allows user to enter whether they want to log in or create an account
        System.out.println("Login: Enter 1");
        System.out.println("Create an account: Enter 2");
        this.userNumber = user.nextInt();


     if(this.userNumber == 1){
       if(this.accountType.equalsIgnoreCase("Customer")){
           CustomerAccount customer = new CustomerAccount("","","","");
           //allows the user to input their login information
            customer.inputLogin(user);
           //checks the users information to see if it's in the database, currently just printing true
//           System.out.println(customer.checkLoginCredentials());
           this.correctLogin = customer.checkLoginCredentials();
       }else if(this.accountType.equalsIgnoreCase("Shipment")){
           ShipmentAccount shipment = new ShipmentAccount("","","","","",0);
           //allows the user to input their login information
            shipment.inputLogin(user);
            //checks the users information to see if it's in the database, currently just printing true
//            System.out.println(shipment.checkLoginCredentials());
           this.correctLogin = shipment.checkLoginCredentials();
       }else if(this.accountType.equalsIgnoreCase("Admin")){
           AdminAccount admin = new AdminAccount("","","","",0);
           //allows the user to input their login information
           admin.inputLogin(user);
           //checks the users information to see if it's in the database, currently just printing true
//           System.out.println(admin.checkLoginCredentials());
           this.correctLogin = admin.checkLoginCredentials();
       }else if(this.accountType.equalsIgnoreCase("Employee")){
           EmployeeAccount employee = new EmployeeAccount("","","","",0);
           //allows the user to input their login information
           employee.inputLogin(user);
           //checks the users information to see if it's in the database, currently just printing true
           //System.out.println(employee.checkLoginCredentials());
           this.correctLogin = employee.checkLoginCredentials();
       }
       //checks whether the users login information is correct
       accountLogin(user);
       }
}
    //checks if the account type is in the array of account types
    public boolean checkAccountType(String userAccountType){
        boolean flag = false;
        userAccountType = userAccountType.toLowerCase();
        for(int i = 0; i < accountTypes.length; i++){
            if(userAccountType.equals(accountTypes[i])){
                flag = true;
                break;
            }
        }
        return flag;
    }
    //NOT DONE YET
    public void createAccount(Scanner user){
        if(this.userNumber == 2){
            //Create a method for writing first name and method for writing last name to database in corresponding account classes
        }
    }
    //presents the user with the homepage or asks them to try again
    public void accountLogin(Scanner user){
        if(this.correctLogin == true){
            //CREATE A UI FOR THIS IN A SEPERATE METHOD THAN CALL IT HERE.
            System.out.println("Blah Blah Blah here is your account.");
        }else{
            System.out.println("Login information incorrect, please try again.");
            //makes the user put their information in again since their login was incorrect using the predefined method
            checkLogin(user);
        }
    }

    //first screen after logging in will be called atr line 128
    public void homePage(){

    }
}
