package com.nilsson.entity;

import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Rental {

    Menu menu = new Menu();
    Inventory inv = Inventory.getInstance();
    MemberRegistry memberRegistry = MemberRegistry.getInstance();

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentLogic() {

        PrintColor.green("\nVill du hyra ut ett fordon eller utrustning? Slå [siffra] och [ENTER]");
        PrintColor.cyan("[1]: Fordon \n[2]: Utrustning");
        PrintColor.red("[0]: Avbryt");
        int choice = menu.scanner.nextInt();

        switch (choice) {

            case 1:
                rentVehicle();
                break;

            case 2:
                rentGear();
                break;

            case 0:
                break;

            default:
                PrintColor.red("Ogiltligt val, försök igen.");
                break;
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentVehicle() {

        inv.printVehicles();
        PrintColor.green("Vilket fordon vill du hyra ut? Tryck [siffra] och [ENTER]: ");
        int index = menu.scanner.nextInt() - 1;
        menu.scanner.nextLine();

        if (index >= 0 && index < inv.getVehicleList().size()) {
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Du valde " + inv.getVehicleList().get(index));
            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
            System.out.println("Ny eller befintlig medlem?");
            PrintColor.cyan("[1]: Ny medlem \n[2]: Befintlig medlem");
            PrintColor.red("[0]: Avbryt");
            menu.menuChoice = menu.scanner.nextInt();

            switch (menu.menuChoice) {

                case 1:
                    memberRegistry.createNewMember(memberRegistry, menu.scanner);
                    int lastIndex = memberRegistry.getMembers().size() - 1;
                    System.out.println("Du hyr nu ut " + inv.getVehicleList().get(index) +
                            "\ntill " + memberRegistry.getMembers().get(lastIndex));
                    PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                    menu.scanner.nextLine();
                    break;

                case 2:
                    memberRegistry.printMembers();
                    int memberIndex = menu.scanner.nextInt() - 1;
                    menu.scanner.nextLine();
                    if (memberIndex >= 0 && index < memberRegistry.getMembers().size()) {
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        System.out.println("Du hyr nu ut " + inv.getVehicleList().get(index) +
                                "\ntill " + memberRegistry.getMembers().get(memberIndex));
                        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                        menu.scanner.nextLine();
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

    public void rentGear() {

        inv.printGear();
        System.out.print("Vilken utrustning vill du hyra ut? Tryck [siffra] och [ENTER]: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
