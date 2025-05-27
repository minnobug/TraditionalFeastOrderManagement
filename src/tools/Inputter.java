/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author LE VAN MINH
 */
public class Inputter {
    private static Scanner sc = new Scanner(System.in);
    
    public static String getString(String msg) {
        System.out.println(msg);
        return sc.nextLine().trim();
    }
    
    public static String inputAndCheck(String msg, String pattern) {
        String data;
        do {
            data = getString(msg);
            if (Acceptable.isValid(data, pattern)) return data;
            System.out.println("Invalid input. Try again.");
        } while (true);
    }
    
    public static int getInt(String msg) {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(getString(msg));
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    
    private static double getDouble(String msg) {
        double number;
        while (true) {
            try {
                number = Double.parseDouble(getString(msg));
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
