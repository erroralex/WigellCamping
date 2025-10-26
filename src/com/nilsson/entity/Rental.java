package com.nilsson.entity;

import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;
import com.nilsson.utils.Start;

import java.util.*;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Rental {

    private Map<Item, Rental> rentedItems = new HashMap<>();
    private Member member;
    private int days;

    Menu menu = new Menu();
    Start start = new Start();
    Inventory inv = Inventory.getInstance();
    MemberRegistry memberRegistry = MemberRegistry.getInstance();

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public Rental() {

    }

    public Rental(Member member, int days) {
        this.member = member;
        this.days = days;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public Map<Item, Rental> getRentedItems() {
    return new HashMap<>(rentedItems);
    }

    public Member getMember() {
        return this.member;
    }

    public int getDays() {
        return this.days;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentLogic() {

        PrintColor.green("\nVill du hyra ut ett fordon eller utrustning? Slå [siffra] och [ENTER]");
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
                PrintColor.red("Ogiltligt val, försök igen.");
                break;
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentVehicleSystem() {

        inv.printVehicles();
        PrintColor.green("Vilket fordon vill du hyra ut? Tryck [siffra] och [ENTER]: ");
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
                    if (memberIndex >= 0 && index < memberRegistry.getMembers().size()) {
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        rentVehicle(inv.getVehicleList().get(index), memberRegistry.getMembers().get(memberIndex));
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        start.scanner.nextLine();
                    }else {
                        PrintColor.red("Ogiltligt val.");
                    }
                    break;

                case 0: //Avbryt
                    break;

                default:

                    break;
            }
        } else {
            PrintColor.red("Ogiltligt val.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentGearSystem() {

        inv.printGear();
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
                    if (memberIndex >= 0 && index < memberRegistry.getMembers().size()) {
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        rentGear(inv.getGearList().get(index), memberRegistry.getMembers().get(memberIndex));
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        start.scanner.nextLine();
                    }else {
                        PrintColor.red("Ogiltligt val.");
                    }
                    break;

                case 0: //Avbryt
                    break;

                default:

                    break;
            }
        } else {
            PrintColor.red("Ogiltligt val.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private void rentVehicle(Vehicle vehicle, Member member) {
        if (inv.getVehicleList().remove(vehicle)) {
            System.out.println("Du hyr nu ut " + vehicle + "\ntill " + member);
            System.out.print("Antal dagar att hyra ut: ");
            int days = start.scanner.nextInt();
            Rental rental = new Rental(member, days);
            rentedItems.put(vehicle, rental);
            PrintColor.green("\nDu har hyrt ut " + vehicle + " \ntill " + member + " i " + days + " dagar.");
            start.scanner.nextLine();
        } else {
            PrintColor.red("Ogiltligt val.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private void rentGear(Gear gear, Member member) {
        if (inv.getGearList().remove(gear)) {
            System.out.println("Du hyr nu ut " + gear + "\ntill " + member);
            System.out.print("Antal dagar att hyra ut: ");
            int days = start.scanner.nextInt();
            Rental rental = new Rental(member, days);
            rentedItems.put(gear, rental);
            PrintColor.green("\nDu har hyrt ut " + gear + " \ntill " + member + " i " + days + " dagar.");
            start.scanner.nextLine();
        } else {
            PrintColor.red("Ogiltligt val.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void showRented() {
        if (rentedItems.isEmpty()) {
            PrintColor.red("Ingen uthyrd utrustning att visa.");
        } else {
            int i = 1;
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            PrintColor.green("Uthyrd Utrustning:");
            for (Map.Entry<Item, Rental> entry : rentedItems.entrySet()) {
                Item item = entry.getKey();
                Member member = entry.getValue().getMember();
                int days = entry.getValue().getDays();
                System.out.println("\n[" + i + "]: " + item + " \nhyrt av: " + member + ", i " + days + " dagar.");
                System.out.println("-------------------------------------------------------------------------------");
                i++;
            }
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void returnItem() {
        if (rentedItems.isEmpty()) {
            PrintColor.red("Det finns inga utlånade föremål att lämna tillbaka.");
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
            PrintColor.green("Du har återlämnat " + itemToReturn + " till lagret.");
        } else {
            PrintColor.red("Ogiltligt val. Var vänlig och ange ett giltligt föremål från listan");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
