package com.nilsson.entity;

import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Rental {

    Menu menu = new Menu();

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

    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void rentGear() {

    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
