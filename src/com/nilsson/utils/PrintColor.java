package com.nilsson.utils;

public class PrintColor {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void red(String text) {
        System.out.println(ANSI_RED + text + ANSI_RESET);
    }

    public static void cyan(String text) {
        System.out.println(ANSI_CYAN + text + ANSI_RESET);
    }

    public static void green(String text) {
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
    }
}