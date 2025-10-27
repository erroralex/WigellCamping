package com.nilsson.utils;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Login {

    public boolean isLoggedIn = false;
    Start start = new Start();

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

    public void logInPrompts() {
        Menu menu = new Menu();
        menu.clearScreen();
        PrintColor.cyan(menu.textBlocks());
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.cyan("---Top-notch Secure Authenticated Log-in System™---");
        PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
        PrintColor.green("\nVar vänlig skriv in ditt användarnamn och [ENTER]: ");

        String userName = start.scanner.nextLine().trim();

        if ((userName == null) || (userName.isEmpty())) {
            PrintColor.red("Du måste skriva in ditt användarnamn! Tryck [ENTER] för att fortsätta:");
            start.scanner.nextLine();
            return;
        }

        System.out.println("\n//Hemlig ledtråd till testare: Lösenord är '0000'");
        PrintColor.green("Var vänlig skriv in ditt lösenord och [ENTER]: ");

        String correctPassword = "0000";
        String userPass;

        while (!this.isLoggedIn) {
            userPass = start.scanner.nextLine();

            if (correctPassword.equals(userPass)) {
                this.isLoggedIn = true;
                PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                System.out.println("Inloggning godkänd! Välkommen " + userName + "!");
                PrintColor.green("────────────────────────────────────────────────────────────────────────────────────");
                System.out.print("Tryck [ENTER] för att fortsätta: ");
                start.scanner.nextLine();
                break;

            } else {
                PrintColor.red("Felaktigt lösenord! Försök igen!");
                PrintColor.green("Var vänlig skriv in ditt lösenord: ");
            }
        }
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}
