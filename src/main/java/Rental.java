public class Rental {

    Customer customer;
    Car car;
    int days;

    public Rental(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
    }

    public double getTotalFee() {
        return car.calculateRentalFee(days);
        //deneme1
    }
}
