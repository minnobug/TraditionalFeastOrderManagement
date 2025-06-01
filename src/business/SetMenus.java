/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

<<<<<<< HEAD
import java.io.*;
import java.util.HashMap;
=======

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
>>>>>>> ab7b6ce (Update 2)
import model.SetMenu;

/**
 *
 * @author LE VAN MINH
 */
public class SetMenus extends HashMap<String, SetMenu> {
<<<<<<< HEAD
    
    public void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("FeastMenu.csv"))) {
            String line = br.readLine(); 
=======

    public void readFromFile() {
        File file = new File("FeastMenu.csv");
        if (!file.exists()) {
            System.out.println("Cannot read data from feastMenu.csv.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // Skip header line if exists
>>>>>>> ab7b6ce (Update 2)
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                String id = parts[0].trim();
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                String ingredients = parts[3].trim();

<<<<<<< HEAD
                SetMenu menu = new SetMenu(id, name, price, ingredients);
                this.put(id, menu);
            }
            System.out.println("Feast menus loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading feast menu file: " + e.getMessage());
=======
                if (ingredients.startsWith("\"") && ingredients.endsWith("\"")) {
                    ingredients = ingredients.substring(1, ingredients.length() - 1);
                }

                SetMenu menu = new SetMenu(id, name, price, ingredients);
                this.put(id, menu);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Cannot read data from feastMenu.csv.");
>>>>>>> ab7b6ce (Update 2)
        }
    }

    public void showMenuList() {
        if (this.isEmpty()) {
<<<<<<< HEAD
            System.out.println("No feast menus available.");
            return;
        }
        System.out.println("============ FEAST MENU LIST ============");
        System.out.println("ID     | Name                 | Price     | Ingredients");
        System.out.println("----------------------------------------------------------");
        for (SetMenu menu : this.values()) {
            System.out.println(menu);
        }
    }
}
=======
            System.out.println("Cannot read data from feastMenu.csv.");
            return;
        }

        List<SetMenu> sortedMenus = new ArrayList<>(this.values());
        sortedMenus.sort(Comparator.comparingDouble(SetMenu::getPrice));

        System.out.println("----------------------------------------------------");
        System.out.println(" List of Set Menus for ordering party:");
        System.out.println("----------------------------------------------------");

        for (SetMenu menu : sortedMenus) {
            System.out.println("Code        : " + menu.getMenuId());
            System.out.println("Name        : " + menu.getMenuName());
            System.out.printf("Price       : %, .0f Vnd\n", menu.getPrice());
            System.out.println("Ingredients :");

            String[] ingLines = menu.getIngredients().split("#");
            for (String ing : ingLines) {
                ing = ing.trim();
                if (!ing.isEmpty()) {
                    System.out.println(ing);
                }
            }
            System.out.println("----------------------------------------------------");
        }
    }
}
>>>>>>> ab7b6ce (Update 2)
