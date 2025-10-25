package com.nilsson.utils;

import com.nilsson.entity.Inventory;
import com.nilsson.entity.MemberRegistry;
import com.nilsson.entity.Rental;
import java.util.InputMismatchException;
import java.util.Scanner;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Start {

    public Scanner scanner = new Scanner(System.in);

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void start() {

        boolean isRunning = true;
        Menu menu = new Menu();
        Login login = new Login();
        Inventory inventory = Inventory.getInstance();
        MemberRegistry memberRegistry = MemberRegistry.getInstance();
        Rental rental = new Rental();


        while (isRunning) {
            if (!login.isLoggedIn) {
                menu.displayLogInScreen();

                try {
                    menu.menuChoice = scanner.nextInt();
                    scanner.nextLine();

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
                            scanner.nextLine();
                            break;
                    }
                } catch (InputMismatchException ex) {
                    PrintColor.red("Ogiltigt inmatning! Var vänlig att försök igen. Tryck [ENTER] för att fortsätta: ");
                    scanner.nextLine();
                    scanner.nextLine();
                }
            } else {
                menu.displayMenuScreen();

                try {
                    menu.menuChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (menu.menuChoice) {
                        case 1:
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            inventory.printInventory();
                            PrintColor.green("\nTryck [ENTER] för att fortsätta: ");
                            scanner.nextLine();
                            break;

                        case 2:
                            // Hyra ut
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            rental.rentLogic();
                            break;

                        case 3:
                            // Visa uthyrda
                            rental.showRented();
                            scanner.nextLine();
                            break;

                        case 4:
                            // returnera
                            break;

                        case 5:
                            // Add members
                            menu.clearScreen();
                            menu.textBlocks();
                            memberRegistry.createNewMember(memberRegistry, scanner);
                            scanner.nextLine();
                            break;

                        case 6:
                            memberRegistry.printMembers();
                            scanner.nextLine();
                            break;

                        case 7:
                            // Edit members
                            memberRegistry.editMember(scanner);
                            break;

                        case 8:
                            //summera intäkter
                            break;

                        case 0:
                            PrintColor.green("Tack för att du använde programmet!");
                            login.isLoggedIn = false;
                            break;

                        default:
                            PrintColor.red("Du måste ange en giltlig siffra. Försök igen. Tryck [ENTER] för att fortsätta: ");
                            scanner.nextLine();
                            break;
                    }
                } catch (InputMismatchException ex) {
                    PrintColor.red("Ogiltigt inmatning! Var vänlig att försök igen. Tryck [ENTER] för att fortsätta: ");
                    scanner.nextLine();
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
