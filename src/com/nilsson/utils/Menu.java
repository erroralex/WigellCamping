package com.nilsson.utils;

public class Menu {

    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public String textBlocks() {
        return """
                ░  ░░░░  ░░        ░░░      ░░░        ░░  ░░░░░░░░  ░░░░░░░░░░░░░░░      ░░░░      ░░░  ░░░░  ░░       ░░░        ░░   ░░░  ░░░      ░░
                ▒  ▒  ▒  ▒▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒  ▒▒▒▒  ▒▒  ▒▒▒▒  ▒▒   ▒▒   ▒▒  ▒▒▒▒  ▒▒▒▒▒  ▒▒▒▒▒    ▒▒  ▒▒  ▒▒▒▒▒▒▒
                ▓        ▓▓▓▓▓  ▓▓▓▓▓  ▓▓▓   ▓▓      ▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓  ▓▓▓▓  ▓▓        ▓▓       ▓▓▓▓▓▓  ▓▓▓▓▓  ▓  ▓  ▓▓  ▓▓▓   ▓
                █   ██   █████  █████  ████  ██  ████████  ████████  ██████████████  ████  ██        ██  █  █  ██  ███████████  █████  ██    ██  ████  █
                █  ████  ██        ███      ███        ██        ██        █████████      ███  ████  ██  ████  ██  ████████        ██  ███   ███      ██
                """;
    }

    public void displayLogInScreen() {
        login.displayLogInScreen();
        try {
            logInChoice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException ex) {
            PrintColor.red("Du måste ange en giltlig siffra. Försök igen. Tryck [ENTER] ");
            scanner.nextLine();
        }
    }

    public void logInMenu() {

        switch (logInChoice) {

            case 1:
                login.loginPrompts();
                break;

            case 0:
                System.out.println("Tack för att du använde programmet!");
                break;

            default:
                System.out.println("Du måste ange en giltlig siffra. Försök igen. Tryck [ENTER] ");
                scanner.nextLine();
                break;
        }
    }

    public void whatToDo() {
        clearScreen();
        PrintColor.cyan(textBlocks());
        System.out.println("\nVälkommen till Wigell Camping! Vad vill du göra idag?");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("[1] - Hyra produkt");
        PrintColor.cyan("[2] - Visa mina hyrda produkter");
        PrintColor.cyan("[3] - Returnera produkt");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("[4] - Visa mitt medlemsskap");
        PrintColor.cyan("[5] - Ändra mitt medlemsskap");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.red("[0] - Avsluta programmet");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\nSkriv in ditt val och tryck [ENTER]: ");
    }

    public void displayMenuCustomer() {
        clearScreen();
        PrintColor.cyan(textBlocks());
        System.out.println("\nVälkommen till Wigell Camping! Vad vill du göra idag?");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("[1] - Hyra produkt");
        PrintColor.cyan("[2] - Visa mina hyrda produkter");
        PrintColor.cyan("[3] - Returnera produkt");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("[4] - Visa mitt medlemsskap");
        PrintColor.cyan("[5] - Ändra mitt medlemsskap");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.red("[0] - Avsluta programmet");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\nSkriv in ditt val och tryck [ENTER]: ");
    }
}
