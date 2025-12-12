public class ElectricCar extends Car {

    public ElectricCar(int id, String brand, double dailyPrice) {
        super(id, brand, dailyPrice);
    }

    @Override
    public double calculateRentalFee(int days) {
        return days * dailyPrice * 0.9;
    }
}
