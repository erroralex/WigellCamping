package com.nilsson.utils;

import com.nilsson.entity.Inventory;
import com.nilsson.entity.MemberRegistry;
import com.nilsson.entity.Rental;

import java.util.InputMismatchException;
import java.util.Scanner;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Menu {

    public Scanner scanner = new Scanner(System.in);
    public int menuChoice;
    private boolean isRunning = true;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public String textBlocks() {
        return """
                ░  ░░░░  ░░        ░░░      ░░░        ░░  ░░░░░░░░  ░░░░░░░░░░░░░░░      ░░░░      ░░░  ░░░░  ░░       ░░░        ░░   ░░░  ░░░      ░░
                ▒  ▒  ▒  ▒▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒   ▒▒   ▒▒  ▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒    ▒▒  ▒▒  ▒▒▒▒▒▒▒
                ▓        ▓▓▓▓▓  ▓▓▓▓▓  ▓▓▓   ▓▓      ▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓        ▓▓       ▓▓▓▓▓▓  ▓▓▓▓▓  ▓  ▓  ▓▓  ▓▓▓   ▓
                █   ██   █████  █████  ████  ██  ████████  ████████  ██████████████  ████  ██        ██  █  █  ██  ███████████  █████  ██    ██  ████  █
                █  ████  ██        ███      ███        ██        ██        █████████      ███  ████  ██  ████  ██  ████████        ██  ███   ███      ██
                """;
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void displayLogInScreen() {
        clearScreen();
        PrintColor.cyan(textBlocks());
        System.out.println("\nVälkommen till Wigell Camping! Var vänlig att logga in:");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("\t\t[1] - Logga in");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.red("\t\t[0] - Avsluta programmet");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\nSkriv in ditt val och tryck [ENTER]: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void displayMenuScreen() {
        clearScreen();
        PrintColor.cyan(textBlocks());
        System.out.println("\nVälkommen till Wigell Camping! Vad vill du göra idag?");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("\t\t[1] - Lista alla tillgängliga produkter");
        PrintColor.cyan("\t\t[2] - Hyra ut produkt");
        PrintColor.cyan("\t\t[3] - Visa uthyrda produkter");
        PrintColor.cyan("\t\t[4] - Returnera produkt(er)");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("\t\t[5] - Skapa nytt medlemsskap");
        PrintColor.cyan("\t\t[6] - Visa medlemsskap");
        PrintColor.cyan("\t\t[7] - Ändra medlemsskap");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.red("\t\t[0] - Avsluta programmet");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\nSkriv in ditt val och tryck [ENTER]: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void start() {

        boolean isRunning = true;
        Login login = new Login();
        Inventory inventory = new Inventory().getInitializedInventory();
        MemberRegistry memberRegistry = new MemberRegistry().getInitializedMembers();
        Rental rental = new Rental();


        while (isRunning) {
            if (!login.isLoggedIn) {
                displayLogInScreen();

                try {
                    menuChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (menuChoice) {
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
                displayMenuScreen();

                try {
                    menuChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (menuChoice) {
                        case 1:
                            clearScreen();
                            PrintColor.cyan(textBlocks());
                            inventory.printInventory();
                            PrintColor.green("\nTryck [ENTER] för att fortsätta: ");
                            scanner.nextLine();
                            break;

                        case 2:
                            // Hyra ut
                            clearScreen();
                            PrintColor.cyan(textBlocks());
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
                            clearScreen();
                            textBlocks();
                            memberRegistry.createNewMember(memberRegistry, scanner);
                            scanner.nextLine();
                            break;

                        case 6:
                            memberRegistry.printMembers();
                            scanner.nextLine();
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