/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispatcher;

import business.Customers;
import business.Orders;
import business.SetMenus;
import java.util.Scanner;

/**
 *
 * @author LE VAN MINH
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customers customers = new Customers();
        Orders orders = new Orders();
        SetMenus menus = new SetMenus();

        menus.readFromFile();
        customers.readFromFile();
        orders.readFromFile();

        int choice = 0;
        do {
            System.out.println("1. Register customers.");
            System.out.println("2. Update customer information.");
            System.out.println("3. Search for customer information by name.");
            System.out.println("4. Display feast menus.");
            System.out.println("5. Place a feast order.");
            System.out.println("6. Update order information.");
            System.out.println("7. Save data to file.");
            System.out.println("8. Display Customer or Order lists.");
            System.out.println("Others - Quit.");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
                continue;
            }

            switch (choice) {
                case 1:
                    customers.addCustomer();
                    break;
                case 2:
                    customers.update();
                    break;
                case 3:
                    customers.searchByName();
                    break;
                case 4:
                    menus.showMenuList();
                    break;
                case 5:
                    orders.addOrder(customers, menus);
                    break;
                case 6:
                    orders.updateOrder(menus);
                    break;
                case 7:
                    customers.saveToFile();
                    orders.saveToFile();
                    break;
                case 8:
                    System.out.println("a. Show Customers");
                    System.out.println("b. Show menus");
                    System.out.println("Enter your option: ");
                    String sub = sc.nextLine().trim();
                    if (sub.equalsIgnoreCase("a")) {
                        customers.showAll();
                    } else if (sub.equalsIgnoreCase("b")) {
<<<<<<< HEAD
                        orders.showAll();
=======
                        orders.showAll(menus);
>>>>>>> ab7b6ce (Update 2)
                    } else {
                        System.out.println("Invalid Option");
                    }
                    break;
                default:
                    System.out.println("Exit program.");
                    choice = 0;
            }
        } while (choice != 0);
    }
}
