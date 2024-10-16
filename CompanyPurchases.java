public class CompanyPurchases extends Financials{

    //Fields
    private double purchaseAmount;

    //Constructor
    public CompanyPurchases(double balance, double purchaseAmount) {
        super(balance);
        this.purchaseAmount = purchaseAmount;
    }

    //Getters and Setters
    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
