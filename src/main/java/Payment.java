public class Payment {

    private int paymentId;
    private Rental rental;
    private double amount;
    private String paymentMethod;

    public Payment(int paymentId, Rental rental, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.rental = rental;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Rental getRental() {
        return rental;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
