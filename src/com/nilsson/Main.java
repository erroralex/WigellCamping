package com.nilsson;

import com.nilsson.utils.Login;
import com.nilsson.utils.Menu;
import com.nilsson.utils.PrintColor;

import java.util.InputMismatchException;

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean isRunning = true;
        Login login = new Login();

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
                menu.whatToDo();

                try {
                    menu.menuChoice = menu.scanner.nextInt();
                    menu.scanner.nextLine();

                    switch (menu.menuChoice) {
                        case 1:
                            // Handle option 1
                            break;

                        case 2:
                            // Handle option 2
                            break;

                        case 3:
                            // Handle option 3
                            break;

                        case 4:
                            // Handle option 4
                            break;

                        case 5:
                            // Handle option 5
                            break;

                        case 0:
                            PrintColor.green("Tack för att du använde programmet!");
                            login.isLoggedIn = false; // Logout the user
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
}
