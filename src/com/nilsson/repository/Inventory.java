package com.nilsson.repository;

import com.nilsson.model.Gear;
import com.nilsson.model.RecreationalVehicle;
import com.nilsson.model.Vehicle;
import com.nilsson.utils.PrintColor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Inventory {

    private List<Vehicle> vehicleList = new ArrayList<>();
    private List<Gear> gearList = new ArrayList<>();

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    private Inventory() {
        initializeInventory();
    }

    public Inventory(List<Vehicle> vehicleList, List<Gear> gearList) {
        this.vehicleList = vehicleList;
        this.gearList = gearList;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public static Inventory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Inventory INSTANCE = new Inventory();
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public List<Gear> getGearList() {
        return gearList;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicleList.add(vehicle);
    }

    public void addGear(Gear gear) {
        this.gearList.add(gear);
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    private void initializeInventory() {

        Vehicle rv1 = new RecreationalVehicle(1500, true, "Vit", 5);
        Vehicle rv2 = new RecreationalVehicle(2000, true, "Svart", 6);
        Vehicle rv3 = new RecreationalVehicle(1800, true, "Grön", 5);
        Vehicle rv4 = new RecreationalVehicle(2200, true, "Brun", 7);
        Vehicle rv5 = new RecreationalVehicle(1600, true, "Blå", 4);
        Vehicle rv6 = new RecreationalVehicle(2300, true, "Rosa", 8);

        Vehicle camper1 = new RecreationalVehicle(800, false, "Lila", 3);
        Vehicle camper2 = new RecreationalVehicle(1100, false, "Gul", 4);
        Vehicle camper3 = new RecreationalVehicle(1500, false, "Grå", 5);
        Vehicle camper4 = new RecreationalVehicle(2200, false, "Vit", 8);
        Vehicle camper5 = new RecreationalVehicle(1900,false, "Brun", 6);

        this.addVehicle(rv1);
        this.addVehicle(rv2);
        this.addVehicle(rv3);
        this.addVehicle(rv4);
        this.addVehicle(rv5);
        this.addVehicle(rv6);

        this.addVehicle(camper1);
        this.addVehicle(camper2);
        this.addVehicle(camper3);
        this.addVehicle(camper4);
        this.addVehicle(camper5);

        Gear tent1 = new Gear(200, 2);
        Gear tent2 = new Gear(250, 3);
        Gear tent3 = new Gear(350, 4);

        Gear backpack1 = new Gear(50, 0);
        Gear backpack2 = new Gear(60, 0);
        Gear backpack3 = new Gear(67, 0);

        this.addGear(tent1);
        this.addGear(tent2);
        this.addGear(tent3);

        this.addGear(backpack1);
        this.addGear(backpack2);
        this.addGear(backpack3);
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void printVehicles() {
        PrintColor.green("Fordon i lager:");
        int i = 1;
        for (Vehicle vehicle : vehicleList) {
            System.out.println(i + ": " + vehicle.toString());
            i++;
        }
        if (vehicleList.isEmpty()) {
            PrintColor.red("\nInga fordon i lager.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void printGear() {
        PrintColor.green("\nUtrustning i lager:");
        int i = 1;
        for (Gear gear : gearList) {
            System.out.println(i + ": " + gear.toString());
            i++;
        }
        if (gearList.isEmpty()) {
            PrintColor.red("\nIngen utrustning i lager.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void inventoryManagement() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            // Fordon
            PrintColor.green("\nFordon i lager:");
            int i = 1;
            for (Vehicle vehicle : vehicleList) {
                System.out.println(i + ": " + vehicle.toString());
                i++;
            }
            if (vehicleList.isEmpty()) {
                PrintColor.red("\nInga fordon i lager.");
            }

            // Utrustning
            PrintColor.green("\nUtrustning i lager:");
            int j = 1;
            for (Gear gear : gearList) {
                System.out.println(j + ": " + gear.toString());
                j++;
            }
            if (gearList.isEmpty()) {
                PrintColor.red("\nIngen utrustning i lager.");
            }

            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            PrintColor.green("Vad vill du göra?");
            PrintColor.cyan("1: Lägg till nytt fordon");
            PrintColor.cyan("2: Ta bort fordon");
            PrintColor.cyan("3: Lägg till ny utrustning");
            PrintColor.cyan("4: Ta bort utrustning");
            PrintColor.red("0: Tillbaka till meny");
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            PrintColor.green("Ange ditt val och tryck ENTER: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                PrintColor.red("Ogiltig inmatning! Ange en siffra.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {

                String vehicleType;
                boolean hasEngine = false;

                while (true) {

                    System.out.print("[Husbil] eller [Husvagn]?: ");
                    vehicleType = scanner.nextLine();

                    if (vehicleType.equalsIgnoreCase("Husbil")) {
                        hasEngine = true;
                        break;

                    } else if (vehicleType.equalsIgnoreCase("Husvagn")) {
                        hasEngine = false;
                        break;

                    } else {
                        PrintColor.red("Ogiltig typ, var god ange [Husbil] eller [Husvagn]:");
                    }
                }

                System.out.print("Ange färg på fordon: ");
                String color = scanner.nextLine();

                double price = -1;

                while (price <= 0) {

                    System.out.print("Grundpris per dygn: ");

                    if (scanner.hasNextDouble()) {

                        price = scanner.nextDouble();
                        scanner.nextLine();

                        if (price <= 0) {

                            PrintColor.red("Priset måste vara mer än 0. Försök igen.");
                        }
                    } else {
                        PrintColor.red("Ogiltlig inmatning, ange ett korrekt värde.");
                        scanner.nextLine();
                    }
                }

                int maxOccupants = -1;
                while (maxOccupants <= 0) {

                    System.out.print("Max antal passagerare: ");

                    if (scanner.hasNextInt()) {

                        maxOccupants = scanner.nextInt();
                        scanner.nextLine();

                        if (maxOccupants <= 0) {

                            PrintColor.red("Kapacitet måste vara mer än 0. Försök igen.");
                        }
                    } else {
                        PrintColor.red("Ogiltlig inmatning, ange ett korrekt värde.");
                        scanner.nextLine();
                    }
                }

                vehicleList.add(new RecreationalVehicle(price, hasEngine, color, maxOccupants));
                System.out.println("Fordon tillagt!");

            } else if (choice == 2) {

                System.out.print("Ange numret på fordonet som ska tas bort: ");
                int removeIndex = scanner.nextInt() - 1;
                scanner.nextLine();

                if (removeIndex >= 0 && removeIndex < vehicleList.size()) {
                    vehicleList.remove(removeIndex);
                    System.out.println("Fordon borttaget!");
                } else {
                    PrintColor.red("Ogiltigt nummer! Försök igen.");
                }

            } else if (choice == 3) {

                String gearType;

                while (true) {

                    System.out.print("[Tält] eller [Ryggsäck]?: ");
                    gearType = scanner.nextLine();

                    if (gearType.equalsIgnoreCase("Tält")) {
                        break;

                    } else if (gearType.equalsIgnoreCase("Ryggsäck")) {
                        break;

                    } else {
                        PrintColor.red("Ogiltlig typ, var god ange [Tält] eller [Ryggsäck]:");
                    }
                }
                int maxOccupants;

                if (gearType.equalsIgnoreCase("Tält")) {

                    maxOccupants = 0;

                    while (maxOccupants < 1) {

                        System.out.print("Hur många personer får plats?");

                        if (scanner.hasNextInt()) {

                            maxOccupants = scanner.nextInt();
                            scanner.nextLine();

                            if (maxOccupants < 1) {

                                PrintColor.red("Antal personer måste vara minst 1. Försök igen.");
                            }
                        } else {
                            PrintColor.red("Ogiltig inmatning, var god ange ett heltal.");
                            scanner.nextLine();
                        }
                    }

                } else {
                    maxOccupants = 0;
                }

                double price = - 1;

                while (price <= 0) {

                    System.out.print("Grundpris per dygn: ");

                    if (scanner.hasNextDouble()) {

                        price = scanner.nextDouble();
                        scanner.nextLine();

                        if (price <= 0) {

                            PrintColor.red("Priset måste vara mer än 0. Försök igen.");
                        }
                    } else {
                        PrintColor.red("Ogiltlig inmatning, ange ett korrekt värde.");
                        scanner.nextLine();
                    }
                }

                gearList.add(new Gear(price, maxOccupants));
                System.out.println("Utrustning tillagd!");

            } else if (choice == 4) {

                System.out.print("Ange numret på utrustningen som ska tas bort: ");
                int removeIndex = scanner.nextInt() - 1;
                scanner.nextLine();

                if (removeIndex >= 0 && removeIndex < gearList.size()) {
                    gearList.remove(removeIndex);
                    System.out.println("Utrustning borttagen!");
                } else {
                    PrintColor.red("Ogiltigt nummer! Försök igen.");
                }

            } else if (choice == 0) {
                break;

            } else {
                PrintColor.red("Ogiltigt val! Försök igen.");
            }
            System.out.println();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
