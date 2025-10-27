package com.nilsson.model;

import com.nilsson.repository.Inventory;
import com.nilsson.repository.MemberRegistry;
import com.nilsson.service.MembershipService;
import com.nilsson.service.RentalService;
import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;
import com.nilsson.utils.Start;

import java.time.LocalDate;
import java.util.*;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Rental {

    private static final Rental INSTANCE = new Rental();
    private Map<Item, Rental> rentedItems = new HashMap<>();
    private Member member;
    private int days;

    Menu menu = new Menu();
    Start start = new Start();
    Inventory inv = Inventory.getInstance();
    MemberRegistry memberRegistry = MemberRegistry.getInstance();
    MembershipService membershipService = new MembershipService();

//── Konstruktorer ─────────────────────────────────────────────────────────────────────────────────────────────────────

    private Rental() {

    }

    public Rental(Member member, int days) {
        this.member = member;
        this.days = days;
    }

//── Getters & Setters ─────────────────────────────────────────────────────────────────────────────────────────────────

    public Map<Item, Rental> getRentedItems() {
    return rentedItems;
    }

    public void setRentedItems(Map<Item, Rental> rentedItems) {
        this.rentedItems = rentedItems;
    }

    public Member getMember() {
        return this.member;
    }

    public int getDays() {
        return this.days;
    }

    public static Rental getInstance() {
        return INSTANCE;
    }

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentLogic() {

        PrintColor.green("\nVill du hyra ut ett fordon eller utrustning? Skriv in [siffra] och [ENTER]");
        PrintColor.cyan("[1]: Fordon \n[2]: Utrustning");
        PrintColor.red("[0]: Avbryt");
        int choice = start.scanner.nextInt();
        start.scanner.nextLine();

        switch (choice) {

            case 1:
                rentVehicleSystem();
                break;

            case 2:
                rentGearSystem();
                break;

            case 0:
                break;

            default:
                PrintColor.red("Ogiltligt val, försök igen. Tryck [ENTER] för att fortsätta:");
                start.scanner.nextLine();
                break;
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentVehicleSystem() {

        inv.printVehicles();
        PrintColor.green("\n────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("\nVilket fordon vill du hyra ut? Skriv in [siffra] och [ENTER]: ");
        int index = start.scanner.nextInt() - 1;
        start.scanner.nextLine();

        if (index >= 0 && index < inv.getVehicleList().size()) {
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Du valde " + inv.getVehicleList().get(index));
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Ny eller befintlig medlem?");
            PrintColor.cyan("[1]: Ny medlem \n[2]: Befintlig medlem");
            PrintColor.red("[0]: Avbryt");
            menu.menuChoice = start.scanner.nextInt();
            start.scanner.nextLine();

            switch (menu.menuChoice) {

                case 1:
                    memberRegistry.createNewMember(memberRegistry, start.scanner);
                    int lastIndex = memberRegistry.getMembers().size() - 1;
                    PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                    rentVehicle(inv.getVehicleList().get(index), memberRegistry.getMembers().get(lastIndex));
                    PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                    start.scanner.nextLine();
                    break;

                case 2:
                    memberRegistry.printMembers();
                    int memberIndex = start.scanner.nextInt() - 1;
                    start.scanner.nextLine();
                    if (memberIndex >= 0 && memberIndex < memberRegistry.getMembers().size()) {
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        rentVehicle(inv.getVehicleList().get(index), memberRegistry.getMembers().get(memberIndex));
                        //PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        start.scanner.nextLine();
                    }else {
                        PrintColor.red("Ogiltligt val.");
                    }
                    break;

                case 0: //Avbryt
                    break;

                default:
                    PrintColor.red("Du måste ange en giltlig siffra. Försök igen. Tryck [ENTER] för att fortsätta: ");
                    start.scanner.nextLine();
                    break;
            }
        } else {
            PrintColor.red("Ogiltligt val. Tryck [ENTER] för att fortsätta:");
            start.scanner.nextLine();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentGearSystem() {

        inv.printGear();
        PrintColor.green("\n────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("Vilken utrustning vill du hyra ut? Tryck [siffra] och [ENTER]: ");
        int index = start.scanner.nextInt() - 1;
        start.scanner.nextLine();

        if (index >= 0 && index < inv.getGearList().size()) {
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Du valde " + inv.getGearList().get(index));
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Ny eller befintlig medlem?");
            PrintColor.cyan("[1]: Ny medlem \n[2]: Befintlig medlem");
            PrintColor.red("[0]: Avbryt");
            menu.menuChoice = start.scanner.nextInt();

            switch (menu.menuChoice) {

                case 1:
                    memberRegistry.createNewMember(memberRegistry, start.scanner);
                    int lastIndex = memberRegistry.getMembers().size() - 1;
                    PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                    rentGear(inv.getGearList().get(index), memberRegistry.getMembers().get(lastIndex));
                    PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                    start.scanner.nextLine();
                    break;

                case 2:
                    memberRegistry.printMembers();
                    int memberIndex = start.scanner.nextInt() - 1;
                    start.scanner.nextLine();
                    if (memberIndex >= 0 && memberIndex < memberRegistry.getMembers().size()) {
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        rentGear(inv.getGearList().get(index), memberRegistry.getMembers().get(memberIndex));
                        //PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        start.scanner.nextLine();
                    }else {
                        PrintColor.red("Ogiltligt val.");
                    }
                    break;

                case 0: //Avbryt
                    break;

                default:
                    PrintColor.red("Du måste ange en giltlig siffra. Försök igen. Tryck [ENTER] för att fortsätta: ");
                    start.scanner.nextLine();
                    break;
            }
        } else {
            PrintColor.red("Ogiltligt val. Tryck [ENTER] för att fortsätta:");
            start.scanner.nextLine();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private void rentVehicle(Vehicle vehicle, Member member) {
        if (inv.getVehicleList().remove(vehicle)) {
            System.out.println("Du hyr nu ut " + vehicle + "\ntill " + member);
            PrintColor.green("Antal dagar att hyra ut: ");
            int days = start.scanner.nextInt();

            Rental rental = new Rental(member, days);
            rentedItems.put(vehicle, rental);

            RentalService rentalService = new RentalService(rental);
            double totalPrice = rentalService.calculatePrice(vehicle, days, member);

            String historyEntry = "Hyrde: " + vehicle + ", i " + days + " dagar den " + LocalDate.now();
            member.getHistory().add(historyEntry);

            PrintColor.green("\nDu har hyrt ut " + vehicle + " \ntill " + member + " i " + days + " dagar.");
            PrintColor.green("Total kostnad: " + totalPrice + ":-");
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Tryck [ENTER] för att fortsätta: ");
            start.scanner.nextLine();
        } else {
            PrintColor.red("Ogiltligt val. Tryck [ENTER] för att fortsätta:");
            start.scanner.nextLine();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private void rentGear(Gear gear, Member member) {
        if (inv.getGearList().remove(gear)) {
            System.out.println("Du hyr nu ut " + gear + "\ntill " + member);
            PrintColor.green("Antal dagar att hyra ut: ");
            int days = start.scanner.nextInt();

            Rental rental = new Rental(member, days);
            rentedItems.put(gear, rental);

            String historyEntry = "Hyrde: " + gear + ", i " + days + " dagar den " + LocalDate.now();
            member.getHistory().add(historyEntry);

            RentalService rentalService = new RentalService(rental);
            double totalPrice = rentalService.calculatePrice(gear, days, member);

            PrintColor.green("\nDu har hyrt ut " + gear + " \ntill " + member + " i " + days + " dagar.");
            PrintColor.green("Total kostnad: " + totalPrice + ":-");
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Tryck [ENTER] för att fortsätta: ");
            start.scanner.nextLine();
        } else {
            PrintColor.red("Ogiltligt val. Tryck [ENTER] för att fortsätta:");
            start.scanner.nextLine();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void showRented() {
        if (rentedItems.isEmpty()) {
            PrintColor.red("Ingen uthyrd utrustning att visa. Tryck [ENTER] för att fortsätta: ");
        } else {
            int i = 1;
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            PrintColor.green("Uthyrd Utrustning:");
            for (Map.Entry<Item, Rental> entry : rentedItems.entrySet()) {
                Item item = entry.getKey();
                Member member = entry.getValue().getMember();
                int days = entry.getValue().getDays();
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("[" + i + "]: " + item + " \nhyrt av: " + member + ", i " + days + " dagar.");
                i++;
            }
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Tryck [ENTER] för att fortsätta: ");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void returnItem() {
        if (rentedItems.isEmpty()) {
            PrintColor.red("Det finns inga utlånade föremål att lämna tillbaka. Tryck [ENTER] för att fortsätta: ");
            return;
        }

        showRented();
        PrintColor.green("Vilket föremål vill du återlämna? Tryck [siffra] och [ENTER]:");
        int index = start.scanner.nextInt() - 1;
        start.scanner.nextLine();

        if (index >= 0 && index < rentedItems.size()) {
            Map.Entry<Item, Rental> entry = new ArrayList<>(rentedItems.entrySet()).get(index);
            Item itemToReturn = entry.getKey();
            Rental rental = entry.getValue();

            rentedItems.remove(itemToReturn);

            if (itemToReturn instanceof Vehicle) {
                inv.getVehicleList().add((Vehicle) itemToReturn);
            } else if (itemToReturn instanceof Gear) {
                inv.getGearList().add((Gear) itemToReturn);
            }

            String historyEntry = "Återlämnande: " + itemToReturn + " den " + LocalDate.now();
            rental.getMember().getHistory().add(historyEntry);

            PrintColor.green("Du har återlämnat " + itemToReturn + " till lagret.");
            System.out.println("Tryck [ENTER] för att fortsätta: ");
        } else {
            PrintColor.red("Ogiltligt val. Var vänlig och ange ett giltligt föremål från listan. Tryck [ENTER] för att fortsätta: ");
            start.scanner.nextLine();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
