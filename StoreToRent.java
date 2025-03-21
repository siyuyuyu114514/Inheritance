import java.util.Scanner;

class StoreToRent {
    private static final double MAINTENANCE_COST = 1000;
    private final double INTEREST_RATE = 0.25;
    private String storeName;
    private String storeBusiness;
    private double totalArea;
    private double sellingPrice;
    private double rent;
    private String minimumLeasePeriod;
    private String floorNumber;
    private boolean available;
    private boolean loanRequired;
    private double loanAmount;
    private int loanPaymentTerm;

    public String getStoreName() {
        return storeName;
    }

    public String getStoreBusiness() {
        return storeBusiness;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getRent() {
        return rent;
    }

    public String getMinimumLeasePeriod() {
        return minimumLeasePeriod;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public double getINTEREST_RATE() {
        return INTEREST_RATE;
    }

    public boolean isLoanRequired() {
        return loanRequired;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getLoanPaymentTerm() {
        return loanPaymentTerm;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStoreBusiness(String storeBusiness) {
        this.storeBusiness = storeBusiness;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setMinimumLeasePeriod(String minimumLeasePeriod) {
        this.minimumLeasePeriod = minimumLeasePeriod;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public StoreToRent(boolean loanRequired, double loanAmount, int loanPaymentTerm) {
        this.loanRequired = loanRequired;
        this.loanAmount = loanAmount;
        this.loanPaymentTerm = loanPaymentTerm;
    }

    public void enterStoreDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Store Name: ");
        setStoreName(input.nextLine());
        System.out.println("Enter Store Business: ");
        setStoreBusiness(input.nextLine());
        System.out.println("Enter Total Area: ");
        setTotalArea(input.nextDouble());
        input.nextLine();
        System.out.println("Enter Selling Price: ");
        setSellingPrice(input.nextDouble());
        input.nextLine();
        System.out.println("Enter Rent: ");
        setRent(input.nextDouble());
        input.nextLine();
        System.out.println("Enter Minimum Lease Period: ");
        setMinimumLeasePeriod(input.nextLine());
        System.out.println("Enter Floor Number: ");
        setFloorNumber(input.nextLine());
        System.out.println("Enter Available: ");
        setAvailable(input.nextBoolean());
        input.close();
    }

    public double calculateLoanFinancing() {
        if (loanRequired) {
            return (loanAmount * (1 + INTEREST_RATE)) / loanPaymentTerm;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "\n" +
                "Store Name: " + storeName + "\n" +
                "Store Business: " + storeBusiness + "\n" +
                "Total Area (sq.m): " + totalArea + "\n" +
                "Selling Price: €" + sellingPrice + "\n" +
                "Rent: €" + rent + "\n" +
                "Minimum Lease Period: " + minimumLeasePeriod + "\n" +
                "Floor Number: " + floorNumber + "\n" +
                "Maintenance Cost: €" + MAINTENANCE_COST + "\n" +
                "Available: " + available + "\n";
    }
}

class StoreOneA extends StoreToRent {
    private boolean specialCustomer;
    private double monthlyPayment;

    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    public void showStoreInfo() {
        System.out.println(toString());
    }

    @Override
    public double calculateLoanFinancing() {
        monthlyPayment = super.calculateLoanFinancing();
        if (specialCustomer) {
            double DISCOUNT_RATE = 0.1;
            monthlyPayment -= (monthlyPayment * DISCOUNT_RATE);
        }
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return "Combining parent toString() \n" + super.toString() + "\n and child toString()\n" +
                "LOAN DETAILS (if applicable):\n" +
                "Loan Amount: " + getLoanAmount() + "\n" +
                "Loan Payment Term: " + getLoanPaymentTerm() + "\n" +
                "Interest Rate: " + getINTEREST_RATE() + "\n" +
                "Special Customer: " + specialCustomer + "\n" +
                "Monthly Loan Payment: " + calculateLoanFinancing();
    }
}