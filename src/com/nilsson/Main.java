package com.nilsson;

import com.nilsson.entity.Inventory;
import com.nilsson.entity.MemberRegistry;
import com.nilsson.entity.Rental;
import com.nilsson.utils.Login;
import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;

import java.util.InputMismatchException;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Main {

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public static void main(String[] args) {

        Menu menu = new Menu();
        boolean isRunning = true;
        Login login = new Login();

        Inventory inventory = new Inventory().getInitializedInventory();
        MemberRegistry memberRegistry = new MemberRegistry().getInitializedMembers();
        Rental rental = new Rental();


        while (isRunning) {
            if (!login.isLoggedIn) {
                menu.displayLogInScreen();

                try {
                    menu.menuChoice = menu.scanner.nextInt();
                    menu.scanner.nextLine();

                    switch (menu.menuChoice) {
                        case 1:
                            login.logInPrompts();
                            if (login.isLoggedIn) {
                                break;
                            }
                            break;

                        case 0:
                            PrintColor.green("Tack för att du använde programmet!");
                            isRunning = false;
                            break;

                        default:
                            PrintColor.red("Du måste ange en giltlig siffra. Försök igen. Tryck [ENTER] för att fortsätta: ");
                            menu.scanner.nextLine();
                            break;
                    }
                } catch (InputMismatchException ex) {
                    PrintColor.red("Ogiltigt inmatning! Var vänlig att försök igen. Tryck [ENTER] för att fortsätta: ");
                    menu.scanner.nextLine();
                    menu.scanner.nextLine();
                }
            } else {
                menu.displayMenuScreen();

                try {
                    menu.menuChoice = menu.scanner.nextInt();
                    menu.scanner.nextLine();

                    switch (menu.menuChoice) {
                        case 1:
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            inventory.printInventory();
                            PrintColor.green("\nTryck [ENTER] för att fortsätta: ");
                            menu.scanner.nextLine();
                            break;

                        case 2:
                            // Hyra ut
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            inventory.printInventory();
                            rental.rentLogic();
                            //menu.scanner.nextLine();
                            break;

                        case 3:
                            // Visa uthyrda
                            break;

                        case 4:
                            // returnera
                            break;

                        case 5:
                            // Add members
                            menu.clearScreen();
                            menu.textBlocks();
                            memberRegistry.createNewMember(memberRegistry, menu.scanner);
                            menu.scanner.nextLine();
                            break;

                        case 6:
                            memberRegistry.printMembers();
                            menu.scanner.nextLine();
                            break;

                        case 7:
                            // Edit members
                            break;

                        case 0:
                            PrintColor.green("Tack för att du använde programmet!");
                            login.isLoggedIn = false;
                            break;

                        default:
                            PrintColor.red("Du måste ange en giltlig siffra. Försök igen. Tryck [ENTER] för att fortsätta: ");
                            menu.scanner.nextLine();
                            break;
                    }
                } catch (InputMismatchException ex) {
                    PrintColor.red("Ogiltigt inmatning! Var vänlig att försök igen. Tryck [ENTER] för att fortsätta: ");
                    menu.scanner.nextLine();
                    menu.scanner.nextLine();
                }
            }
        }
        menu.scanner.close();
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
