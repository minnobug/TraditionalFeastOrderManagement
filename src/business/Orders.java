/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author LE VAN MINH
 */
import model.Order;
import tools.FileUtils;
import tools.Inputter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders extends ArrayList<Order> {
    private final String pathFile = "orders.dat";
<<<<<<< HEAD
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

=======
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
>>>>>>> ab7b6ce (Update 2)

    public void addOrder(Customers customers, SetMenus menus) {
        String orderCode;
        while (true) {
<<<<<<< HEAD
            orderCode = Inputter.getString("Enter Order Code (e.g. O001): ").toUpperCase();
=======
            orderCode = Inputter.getString("Enter Order Code: ").toUpperCase();
>>>>>>> ab7b6ce (Update 2)
            if (searchById(orderCode) == null) break;
            System.out.println("Order Code already exists.");
        }

        String customerId;
        while (true) {
            customerId = Inputter.getString("Enter Customer ID: ").toUpperCase();
            if (customers.searchById(customerId) != null) break;
            System.out.println("Customer not found.");
        }

        String province = Inputter.getString("Enter province for the event: ");

        String menuId;
        while (true) {
            menuId = Inputter.getString("Enter Menu ID: ").toUpperCase();
            if (menus.containsKey(menuId)) break;
            System.out.println("Menu ID not found.");
        }

        int numTables = Inputter.getInt("Enter number of tables: ");

        Date eventDate;
        while (true) {
            String dateInput = Inputter.getString("Enter event date (yyyy-MM-dd): ");
            try {
<<<<<<< HEAD
                eventDate = sdf.parse(dateInput);
=======
                eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
>>>>>>> ab7b6ce (Update 2)
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        this.add(new Order(orderCode, customerId, province, menuId, numTables, eventDate));
        System.out.println("Order placed successfully.");
    }

<<<<<<< HEAD

=======
>>>>>>> ab7b6ce (Update 2)
    public void updateOrder(SetMenus menus) {
        String id = Inputter.getString("Enter Order Code to update: ").toUpperCase();
        Order o = searchById(id);
        if (o == null) {
            System.out.println("Order not found.");
            return;
        }

        int newQty = Inputter.getInt("Enter new number of tables: ");

        Date newDate;
        while (true) {
            String dateInput = Inputter.getString("Enter new event date (yyyy-MM-dd): ");
            try {
<<<<<<< HEAD
                newDate = sdf.parse(dateInput);
=======
                newDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
>>>>>>> ab7b6ce (Update 2)
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        o.setNumOfTables(newQty);
        o.setEventDate(newDate);
        System.out.println("Order updated.");
    }

<<<<<<< HEAD
    public void showAll() {
        if (this.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        System.out.println("=================== ORDER LIST ===================");
        for (Order o : this) {
            System.out.println(o);
        }
=======
    public void showAll(SetMenus menus) {
        if (this.isEmpty()) {
            System.out.println("No data in the system.");
            return;
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(" ID   | Event date |Customer ID| Set Menu |    Price    |Tables|  Cost");
        System.out.println("---------------------------------------------------------------------------");

        for (Order o : this) {
            String menuId = o.getMenuId();
            double price = 0;
            if (menus != null && menus.containsKey(menuId)) {
                price = menus.get(menuId).getPrice();
            }
            double cost = price * o.getNumOfTables();
            System.out.printf("%-7s| %-11s| %-11s| %-9s| %,8.0f| %4d| %,7.0f\n",
                    o.getOrderCode(), sdf.format(o.getEventDate()), o.getCustomerId(),
                    menuId, price, o.getNumOfTables(), cost);
        }
        System.out.println("---------------------------------------------------------------------------");
>>>>>>> ab7b6ce (Update 2)
    }

    public Order searchById(String id) {
        for (Order o : this) {
            if (o.getOrderCode().equalsIgnoreCase(id)) return o;
        }
        return null;
    }

    public void saveToFile() {
        FileUtils.saveObjectToFile(this, pathFile);
        System.out.println("Orders saved to file.");
    }

    public void readFromFile() {
        List<Order> data = FileUtils.readObjectFromFile(pathFile);
        if (data != null) {
            this.clear();
            this.addAll(data);
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> ab7b6ce (Update 2)
