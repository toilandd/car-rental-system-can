public class Rental {

    private Customer customer;
    private Car car;
    private int days;

    public Rental(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
    }

    public double getTotalFee() {
        return car.calculateRentalFee(days);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }
}
