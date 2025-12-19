import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CarInventory inventory = new CarInventory();
        boolean running = true;

        System.out.println("=== CAR RENTAL SYSTEM ===");

        while (running) {

            System.out.println("\n1. Add car");
            System.out.println("2. Remove car");
            System.out.println("3. Display available cars");
            System.out.println("4. Rent a car");
            System.out.println("5. Return a car");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (choice) {

                // ✅ ADD CAR
                case 1:
                    System.out.print("Enter car id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();

                    System.out.print("Enter daily price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Car type (1 = Electric, 2 = Gas): ");
                    int type = scanner.nextInt();

                    Car car;
                    if (type == 1) {
                        car = new ElectricCar(id, brand, price);
                    } else {
                        car = new GasCar(id, brand, price);
                    }

                    inventory.addCar(car);
                    break;

                // ✅ REMOVE CAR
                case 2:
                    System.out.print("Enter car id to remove: ");
                    int removeId = scanner.nextInt();
                    inventory.removeCar(removeId);
                    break;

                // (şimdilik sadece yazı)
                case 3:
                    inventory.displayAvailableCars();
                    break;

                case 4:
                    System.out.println("Rent car selected (to be implemented)");
                    break;

                case 5:
                    System.out.println("Return car selected (to be implemented)");
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

        scanner.close();
    }
}
