/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.io.*;
import java.util.HashMap;
import model.SetMenu;

/**
 *
 * @author LE VAN MINH
 */
public class SetMenus extends HashMap<String, SetMenu> {
    
    public void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("FeastMenu.csv"))) {
            String line = br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                String id = parts[0].trim();
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());
                String ingredients = parts[3].trim();

                SetMenu menu = new SetMenu(id, name, price, ingredients);
                this.put(id, menu);
            }
            System.out.println("Feast menus loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading feast menu file: " + e.getMessage());
        }
    }

    public void showMenuList() {
        if (this.isEmpty()) {
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
