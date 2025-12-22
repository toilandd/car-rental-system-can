import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarInventory {

    private List<Car> cars = new ArrayList<>();
    private final String FILE = "cars.csv";

    public CarInventory() {
        load();
    }

    // ---------- BASIC ----------
    public void addCar(Car car) {
        cars.add(car);
        save();
    }

    public void removeCar(int id) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).id == id) {
                cars.remove(i);
                break;
            }
        }
        save();
    }

    public Car getCarById(int id) {
        for (Car c : cars) {
            if (c.id == id) return c;
        }
        return null;
    }

    // ---------- RENT / TESLİM ----------
    public boolean rentCar(int id) {
        Car c = getCarById(id);
        if (c == null || !c.available) return false;
        c.available = false;
        save();
        return true;
    }

    public boolean returnCar(int id) {
        Car c = getCarById(id);
        if (c == null) return false;
        c.available = true;
        save();
        return true;
    }

    // ---------- DISPLAY ----------
    public void displayAvailableCars() {
        for (Car c : cars) {
            if (c.available) {
                String type = (c instanceof ElectricCar) ? "Electric" : "Benzin";
                System.out.println(
                        c.id + " - " + c.brand +
                        " | " + type +
                        " | Gunluk: " + c.dailyPrice + " TL"
                );
            }
        }
    }

    public void displayAllCars() {
        for (Car c : cars) {
            String type = (c instanceof ElectricCar) ? "Electric" : "Benzin";
            System.out.println(
                    c.id + " - " + c.brand +
                    " | " + type +
                    " | " + c.dailyPrice +
                    " | Musait: " + c.available
            );
        }
    }

    // ---------- CSV LOAD ----------
    private void load() {
        File f = new File(FILE);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            br.readLine(); // header
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                int id = Integer.parseInt(d[0]);
                String brand = d[1];
                double price = Double.parseDouble(d[2]);
                String type = d[3];
                boolean available = Boolean.parseBoolean(d[4]);

                Car c = type.equals("ELECTRIC")
                        ? new ElectricCar(id, brand, price)
                        : new GasCar(id, brand, price);

                c.available = available;
                cars.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------- CSV SAVE ----------
    private void save() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            pw.println("id,brand,dailyPrice,type,available");
            for (Car c : cars) {
                String type = (c instanceof ElectricCar) ? "ELECTRIC" : "BENZIN";
                pw.println(
                        c.id + "," +
                        c.brand + "," +
                        c.dailyPrice + "," +
                        type + "," +
                        c.available
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
