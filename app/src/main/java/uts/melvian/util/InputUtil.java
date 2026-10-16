package uts.melvian.util;

import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka integer! Masukkan lagi: ");
            }
        }
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Input harus berupa angka desimal! Masukkan lagi: ");
            }
        }
    }

    public static char readChar() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (!input.isEmpty()) {
                    return input.charAt(0);
                }
                System.out.print("Input tidak boleh kosong! Masukkan lagi: ");
            } catch (Exception e) {
                System.out.print("Input karakter tidak valid! Masukkan lagi: ");
            }
        }
    }
}
