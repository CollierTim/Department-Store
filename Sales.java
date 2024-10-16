public class Sales extends Financials{

    //Fields
    private double salesAmount;

    //Constructor
    public Sales(double balance, double salesAmount) {
        super(balance);
        this.salesAmount = salesAmount;
    }

    //Getter and Setter
    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }
}
