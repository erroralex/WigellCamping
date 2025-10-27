package com.nilsson.utils;

import com.nilsson.repository.Inventory;
import com.nilsson.repository.MemberRegistry;
import com.nilsson.model.Rental;
import com.nilsson.service.RentalService;
import java.util.InputMismatchException;
import java.util.Scanner;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Start {

    public Scanner scanner = new Scanner(System.in);

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void start() {

        boolean isRunning = true;
        Menu menu = new Menu();
        Login login = new Login();
        Inventory inventory = Inventory.getInstance();
        MemberRegistry memberRegistry = MemberRegistry.getInstance();
        Rental rental = Rental.getInstance();
        RentalService rentalService = new RentalService(rental);

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
                        case 1: // Lista tillgängliga
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            inventory.printInventory();
                            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("Tryck [ENTER] för att fortsätta: ");
                            scanner.nextLine();
                            break;

                        case 2: // Hyra ut
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            rental.rentLogic();
                            break;

                        case 3: // Visa uthyrda
                            rental.showRented();
                            scanner.nextLine();
                            break;

                        case 4:
                            // Returnera föremål
                            rental.returnItem();
                            scanner.nextLine();
                            break;

                        case 5: // Lägg till medlemmar
                            menu.clearScreen();
                            menu.textBlocks();
                            memberRegistry.createNewMember(memberRegistry, scanner);
                            scanner.nextLine();
                            break;

                        case 6: // Visa medlemsskap
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            memberRegistry.printMembers();
                            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                            System.out.println("Tryck [ENTER] för att fortsätta: ");
                            scanner.nextLine();
                            break;

                        case 7: // Redigera medlemmar
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            memberRegistry.editMember(scanner);
                            break;

                        case 8: // Summera intäkter
                            double totalProfit = rentalService.calculateTotalProfit();
                            if (totalProfit > 0) {
                                PrintColor.green("Beräknad intäkt av nu uthyrda föremål: " + totalProfit + ":-");
                                System.out.println("Tryck [ENTER] för att fortsätta: ");
                            } else {
                                PrintColor.red("Hittade inga uthyrda föremål. Tryck [ENTER] för att fortsätta: ");
                            }
                            scanner.nextLine();
                            break;

                        case 0: // Logga ut
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
