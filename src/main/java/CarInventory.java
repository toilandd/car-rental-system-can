import java.util.ArrayList;
import java.util.List;

public class CarInventory {

    private List<Car> cars;

    public CarInventory() {
        this.cars = new ArrayList<>();
    }

  
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Araç eklendi: " + car.getBrand());
    }

    
    public void removeCar(int carId) {
        cars.removeIf(car -> car.getId() == carId);
        System.out.println("Araç silindi. ID: " + carId);
    }

  
    public void displayAllCars() {
        for (Car car : cars) {
            System.out.println(
                "ID: " + car.getId() +
                ", Marka: " + car.getBrand() +
                ", Günlük Ücret: " + car.dailyPrice +
                ", Müsait: " + car.isAvailable()
            );
        }
    }

    public void displayAvailableCars() {
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(
                    "ID: " + car.getId() +
                    ", Marka: " + car.getBrand() +
                    ", Günlük Ücret: " + car.dailyPrice
                );
            }
        }
    }

    public Car getCarById(int carId) {
        for (Car car : cars) {
            if (car.getId() == carId) {
                return car;
            }
        }
        return null;
    }
}
