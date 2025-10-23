package com.nilsson.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {

    public int loginChoice;
    public boolean isLoggedIn = false;
    private Scanner scanner = new Scanner(System.in);

    public void displayLogInScreen() {
        clearScreen();
        PrintColor.green("Login Screen\n");
        System.out.println("\nVälkommen till Wigell Rental! Var vänlig att logga in:");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("[1] - Logga in");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.red("[0] - Avsluta programmet");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\nSkriv in ditt val och tryck [ENTER]: ");
    }

    public void logInPrompts() {
        clearScreen();
        PrintColor.cyan("Login Prompts\n");
        PrintColor.green("\nVar vänlig skriv in ditt användarnamn: ");

        String userName = scanner.nextLine();

        if ((userName == null) || (userName.isEmpty())) {
            PrintColor.red("Du måste skriva in ditt användarnamn!");
        }

        System.out.println("\n//Hemlig ledtråd till testare: Lösenord är '0000'");
        PrintColor.green("Var vänlig skriv in ditt lösenord: ");

        String correctPassword = "0000";
        String userPass;

        boolean isLoggedIn = false;

        while (!isLoggedIn) {

            userPass = scanner.nextLine();

            if (correctPassword.equals(userPass)) {
                isLoggedIn = true;
                System.out.println("Inloggning godkänd!");
                break;

            } else {
                PrintColor.red("Felaktigt lösenord! Försök igen!");
                PrintColor.green("Var vänlig skriv in ditt lösenord: ");
            }
        }
        scanner.nextLine();
    }

    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
