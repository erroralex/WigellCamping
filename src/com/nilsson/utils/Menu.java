package com.nilsson.utils;

//── Klass & Attribut ──────────────────────────────────────────────────────────────────────────────────────────────────

public class Menu {

    public int menuChoice;

//── Metoder ───────────────────────────────────────────────────────────────────────────────────────────────────────────

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
        PrintColor.cyan("\t\t[1] - Produkter");
        PrintColor.cyan("\t\t[2] - Hyra ut produkt");
        PrintColor.cyan("\t\t[3] - Visa uthyrda produkter");
        PrintColor.cyan("\t\t[4] - Returnera produkt(er)");
        PrintColor.cyan("\t\t[5] - Utlåningshistorik");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.cyan("\t\t[6] - Skapa nytt medlemsskap");
        PrintColor.cyan("\t\t[7] - Visa medlemmar");
        PrintColor.cyan("\t\t[8] - Redigera medlemsskap");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\t\t[9] - Summera intäkter");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.red("\t\t[0] - Logga ut");
        System.out.println("───────────────────────────────────────────────────────");
        PrintColor.green("\nSkriv in ditt val och tryck [ENTER]: ");
    }

//──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

}