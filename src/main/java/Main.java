import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarInventory inventory = new CarInventory();
        String ADMIN_PASSWORD = "admin123";

        while (true) {

            System.out.println("\n1- Admin");
            System.out.println("2- Customer");
            System.out.println("0- Exit");
            System.out.print("Secim: ");
            int role = sc.nextInt();

            if (role == 0) break;

            // ===== ADMIN =====
            if (role == 1) {
                sc.nextLine();
                System.out.print("Admin sifre: ");
                String pass = sc.nextLine();

                if (!pass.equalsIgnoreCase(ADMIN_PASSWORD)) {
                    System.out.println("Yanlis sifre!");
                    continue;
                }

                System.out.println("1- Arac ekle");
                System.out.println("2- Arac sil");
                System.out.println("3- Tum araclar");
                int sec = sc.nextInt();

                if (sec == 1) {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Model: ");
                    String brand = sc.nextLine();

                    System.out.print("Gunluk ucret: ");
                    double price = sc.nextDouble();

                    System.out.print("Tip (1=Elektrik, 2=Benzin): ");
                    int type = sc.nextInt();

                    Car car = (type == 1)
                            ? new ElectricCar(id, brand, price)
                            : new GasCar(id, brand, price);

                    inventory.addCar(car);
                    System.out.println("Arac eklendi.");
                }

                else if (sec == 2) {
                    System.out.print("Silinecek ID: ");
                    inventory.removeCar(sc.nextInt());
                    System.out.println("Arac silindi.");
                }

                else if (sec == 3) {
                    inventory.displayAllCars();
                }
            }

            // ===== CUSTOMER =====
            else if (role == 2) {

                boolean customerMenu = true;

                while (customerMenu) {
                    System.out.println("\n1- Musait araclar");
                    System.out.println("2- Arac kirala");
                    System.out.println("3- Araci teslim et");
                    System.out.println("0- Geri don");
                    System.out.print("Secim: ");
                    int sec = sc.nextInt();

                    if (sec == 1) {
                        inventory.displayAvailableCars();
                    }

                    else if (sec == 2) {
                        inventory.displayAvailableCars();
                        System.out.print("Arac ID: ");
                        int id = sc.nextInt();

                        System.out.print("Gun sayisi: ");
                        int day = sc.nextInt();

                        if (inventory.rentCar(id)) {
                            Car car = inventory.getCarById(id);
                            Rental r = new Rental(new Customer(1, "Guest"), car, day);
                            System.out.println("Arac basariyla kiralandi.");
                            System.out.println("Toplam ucret: " + r.getTotalFee() + " TL");
                        } else {
                            System.out.println("Arac musait degil.");
                        }
                    }

                    else if (sec == 3) {
                        System.out.print("Teslim ID: ");
                        if (inventory.returnCar(sc.nextInt())) {
                            System.out.println("Arac basariyla teslim edildi.");
                        } else {
                            System.out.println("Hatali islem.");
                        }
                    }

                    else if (sec == 0) {
                        customerMenu = false;
                    }
                }
            }
        }

        sc.close();
    }
}
