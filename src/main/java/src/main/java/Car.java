public abstract class Car implements Rentable {

    int id;
    String brand;
    double dailyPrice;
    boolean available = true;

    public Car(int id, String brand, double dailyPrice) {
        this.id = id;
        this.brand = brand;
        this.dailyPrice = dailyPrice;
    }

    public boolean isAvailable() {
        return available;
    }
}
