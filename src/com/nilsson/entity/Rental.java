package com.nilsson.entity;

import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;
import com.nilsson.utils.Start;

import java.util.*;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Rental {

    private Map<Item, Member> rentedItems = new HashMap<>();

    Menu menu = new Menu();
    Start start = new Start();
    Inventory inv = Inventory.getInstance();
    MemberRegistry memberRegistry = MemberRegistry.getInstance();

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentLogic() {

        PrintColor.green("\nVill du hyra ut ett fordon eller utrustning? Slå [siffra] och [ENTER]");
        PrintColor.cyan("[1]: Fordon \n[2]: Utrustning");
        PrintColor.red("[0]: Avbryt");
        int choice = start.scanner.nextInt();

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
            rentedItems.put(vehicle, member);
            System.out.println("Du hyr nu ut " + vehicle + "\ntill " + member);
        } else {
            PrintColor.red("Ogiltligt val.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    private void rentGear(Gear gear, Member member) {
        if (inv.getGearList().remove(gear)) {
            rentedItems.put(gear, member);
            System.out.println("Du hyr nu ut " + gear + "\ntill " + member);
        } else {
            PrintColor.red("Ogiltligt val.");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void showRented() {
        if (rentedItems.isEmpty()) {
            PrintColor.red("Ingen utlånad utrustning att visa.");
        } else {
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Utlånad Utrustning:");
            for (Map.Entry<Item, Member> entry : rentedItems.entrySet()) {
                Item item = entry.getKey();
                Member member = entry.getValue();
                System.out.println(item + " hyrt av: " + member);
            }
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
