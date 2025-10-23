package com.nilsson.utils;

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

    public void whatToDo() {
        clearScreen();
        PrintColor.cyan(textBlocks());
        System.out.println("\nVälkommen till Wigell Camping! Vad vill du göra idag?");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("\t\t[1] - Hyra ut produkt");
        PrintColor.cyan("\t\t[2] - Visa uthyrda produkter");
        PrintColor.cyan("\t\t[3] - Returnera produkt(er)");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("\t\t[4] - Visa medlemsskap");
        PrintColor.cyan("\t\t[5] - Ändra medlemsskap");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.red("\t\t[0] - Avsluta programmet");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\nSkriv in ditt val och tryck [ENTER]: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}