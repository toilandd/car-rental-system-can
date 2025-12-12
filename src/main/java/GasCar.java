public class GasCar extends Car {

    public GasCar(int id, String brand, double dailyPrice) {
        super(id, brand, dailyPrice);
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * dailyPrice;
    }
}
