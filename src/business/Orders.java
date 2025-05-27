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
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public void addOrder(Customers customers, SetMenus menus) {
        String orderCode;
        while (true) {
            orderCode = Inputter.getString("Enter Order Code (e.g. O001): ").toUpperCase();
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
                eventDate = sdf.parse(dateInput);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        this.add(new Order(orderCode, customerId, province, menuId, numTables, eventDate));
        System.out.println("Order placed successfully.");
    }


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
                newDate = sdf.parse(dateInput);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Try again.");
            }
        }

        o.setNumOfTables(newQty);
        o.setEventDate(newDate);
        System.out.println("Order updated.");
    }

    public void showAll() {
        if (this.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        System.out.println("=================== ORDER LIST ===================");
        for (Order o : this) {
            System.out.println(o);
        }
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
}