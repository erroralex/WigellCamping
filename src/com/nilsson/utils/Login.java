package com.nilsson.utils;

public class Login {

    public boolean isLoggedIn = false;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void logInPrompts() {
        Menu menu = new Menu();
        menu.clearScreen();
        PrintColor.cyan(menu.textBlocks());
        PrintColor.green("\nVar vänlig skriv in ditt användarnamn: ");

        String userName = menu.scanner.nextLine().trim();

        if ((userName == null) || (userName.isEmpty())) {
            PrintColor.red("Du måste skriva in ditt användarnamn!");
            return;
        }

        System.out.println("\n//Hemlig ledtråd till testare: Lösenord är '0000'");
        PrintColor.green("Var vänlig skriv in ditt lösenord: ");

        String correctPassword = "0000";
        String userPass;

        while (!this.isLoggedIn) {
            userPass = menu.scanner.nextLine();

            if (correctPassword.equals(userPass)) {
                this.isLoggedIn = true;
                System.out.println("Inloggning godkänd! Tryck [ENTER] för att fortsätta: ");
                menu.scanner.nextLine();
                break;

            } else {
                PrintColor.red("Felaktigt lösenord! Försök igen!");
                PrintColor.green("Var vänlig skriv in ditt lösenord: ");
            }
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
