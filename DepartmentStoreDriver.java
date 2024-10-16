import java.util.Scanner;
public class DepartmentStoreDriver {
    public static void main(String[] args){
        Scanner user = new Scanner(System.in);
        //Constructs user experience object
        UserExperience ux = new UserExperience();

        //greets the user
        ux.greetingMessage(user);
        //checks whether users information is in the database
        ux.checkLogin(user);

//        CustomerAccount customerAccount = new CustomerAccount("John", "Mann", "birdistheword", "fancy");
//        System.out.println(customerAccount.checkLoginCredentials());
//        EmployeeAccount employeeAccount = new EmployeeAccount("Todd", "Jones", "User", "Password", 1);
//        System.out.println(employeeAccount.checkLoginCredentials());
//        ShipmentAccount shipmentAccount = new ShipmentAccount("John", "Bones", "billybob", "billyjoel", "Company", 1);
//        System.out.println(shipmentAccount.checkLoginCredentials());
//        AdminAccount adminAccount = new AdminAccount("John", "Bones", "billybob", "billyjoel", 1);
//        System.out.println(adminAccount.checkLoginCredentials());

    }
}
