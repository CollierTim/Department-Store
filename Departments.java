import java.util.LinkedList;
import java.sql.DriverManager;
public abstract class Departments {
    //Fields
    private int totalItemCount; //total items in that department
    private LinkedList<String> items;
    private LinkedList<String> userPurchases;
    private double itemCost;
    private double departmentBalance;
    private double departmentProfits;


    public Departments(){
        this.totalItemCount = 0;
        this.items = null;
        this.userPurchases = null;
        this.itemCost = 0.0;
        this.departmentBalance = 0.0;
        this.departmentProfits = 0.0;
    }
    //Accessors and Mutators
    //Count
    public int getTotalItemCountCount(){
        return this.totalItemCount;
    }
    public void setTotalItemCountCount(int numOfItems){
        this.totalItemCount = this.totalItemCount + numOfItems;
    }
    //Items
    public LinkedList<String> getItems(){
        return this.items;
    }
    public void setItems(String item){
        this.items.add(item);
    }
    //userPurchases
    public LinkedList<String> getUserPurchases(){
        return this.userPurchases;
    }
    public void setUserPurchases(String userItem){
        this.userPurchases.add(userItem);
    }
    //Item Cost
    public double getItemCost(){
        return this.itemCost;
    }
    public void setItemCost(double newCost){
        this.itemCost = newCost;
    }

}
