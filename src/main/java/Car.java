public abstract class Car implements Rentable {

    protected int id;
    protected String brand;
    protected double dailyPrice;
    protected boolean available = true;

    public Car(int id, String brand, double dailyPrice) {
        this.id = id;
        this.brand = brand;
        this.dailyPrice = dailyPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }
}
