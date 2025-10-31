package com.nilsson.utils;

import com.nilsson.repository.Inventory;
import com.nilsson.repository.MemberRegistry;
import com.nilsson.model.Rental;
import com.nilsson.service.MembershipService;
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
        MembershipService membershipService = new MembershipService();
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
                            break;

                        case 2: // Hyra ut
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            rentalService.rentLogic();
                            break;

                        case 3: // Visa uthyrda
                            rentalService.showRented();
                            System.out.print("Tryck [ENTER] för att fortsätta: ");
                            scanner.nextLine();
                            break;

                        case 4:
                            // Returnera föremål
                            rentalService.returnItem();
                            scanner.nextLine();
                            break;

                        case 5: // Utlåningshistorik
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            membershipService.printAllRentalHistories();
                            System.out.print("Tryck [ENTER] för att fortsätta: ");
                            scanner.nextLine();
                            break;

                        case 6: // Lägg till medlemmar
                            menu.clearScreen();
                            menu.textBlocks();
                            membershipService.createNewMember(memberRegistry, scanner);
                            scanner.nextLine();
                            break;

                        case 7: // Visa medlemsskap
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            membershipService.printAndSortMembers();
                            PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                            break;

                        case 8: // Redigera medlemmar
                            menu.clearScreen();
                            PrintColor.cyan(menu.textBlocks());
                            membershipService.editMember(scanner);
                            break;

                        case 9: // Summera intäkter
                            double totalProfit = rentalService.calculateTotalProfit();
                            if (totalProfit > 0) {
                                menu.clearScreen();
                                PrintColor.cyan(menu.textBlocks());
                                PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                                PrintColor.green("Beräknad intäkt av nu uthyrda föremål: " + totalProfit + ":-");
                                PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                                System.out.print("Tryck [ENTER] för att fortsätta: ");
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
