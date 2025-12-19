import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
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

            switch (choice) {

                case 1:
                    System.out.println("Add car selected");
                    break;

                case 2:
                    System.out.println("Remove car selected");
                    break;

                case 3:
                    System.out.println("Display available cars selected");
                    break;

                case 4:
                    System.out.println("Rent car selected");
                    break;

                case 5:
                    System.out.println("Return car selected");
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
