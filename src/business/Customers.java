/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import model.Customer;
import tools.Acceptable;
import tools.Inputter;
import tools.FileUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LE VAN MINH
 */
public class Customers extends ArrayList<Customer> {
    private final String pathFile = "customer.dat";
    public void addCustomer(){
        String id;
        while(true) {
            id = Inputter.inputAndCheck("Enter Customer ID (C,G,K + 4 digits): ", Acceptable.CUS_ID_VALID).toUpperCase();
            if (searchById(id) == null) break;
            System.out.println("This ID already exists. Try another.");
        }
        String name = Inputter.inputAndCheck("Enter Name: ", Acceptable.NAME_VALID);
        String phone = Inputter.inputAndCheck("Enter Phone: ",Acceptable.PHONE_VALID);
        String email = Inputter.inputAndCheck("Enter email: ",Acceptable.EMAIL_VALID);
        
        this.add(new Customer(id,name,phone,email));
        System.out.println("Customer registered sucessfully.");
    }
    
    public void update() {
        String id = Inputter.inputAndCheck("Enter customer ID to update: ", Acceptable.CUS_ID_VALID).toUpperCase();
        Customer c = searchById(id);
        if(c == null) {
            System.out.println("Customer not found.");
            return;
        }
        
        String name = Inputter.inputAndCheck("New Name: ",Acceptable.NAME_VALID);
        String phone = Inputter.inputAndCheck("New Phone: ", Acceptable.PHONE_VALID);
        String email = Inputter.inputAndCheck("New Email: ", Acceptable.EMAIL_VALID);

        c.setName(name);
        c.setPhone(phone);
        c.setEmail(email);
        System.out.println("Customer updated.");
    }
    
    public void searchByName() {
        String keyword = Inputter.getString("Enter customer name: ").toLowerCase();
        List<Customer> result = new ArrayList<>();
        for (Customer c : this) {
            if (c.getName().toLowerCase().contains(keyword)) {
                result.add(c);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No customer found.");
        } else {
            showAll(result);
        }
    }

    public void showAll() {
        if (this.isEmpty()) {
            System.out.println("No customer available.");
            return;
        }
        System.out.println("ID     | Name                 | Phone     | Email");
        System.out.println("-------------------------------------------------------------");
        for (Customer c : this) {
            System.out.println(c);
        }
    }

    public void showAll(List<Customer> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No customer to show.");
            return;
        }
        System.out.println("ID     | Name                 | Phone     | Email");
        System.out.println("-------------------------------------------------------------");
        for (Customer c : list) {
            System.out.println(c);
        }
    }

    public Customer searchById(String id) {
        for (Customer c : this) {
            if (c.getId().equalsIgnoreCase(id)) return c;
        }
        return null;
    }

    public void saveToFile() {
        FileUtils.saveObjectToFile(this, pathFile);
        System.out.println("Customers saved to file.");
    }

    public void readFromFile() {
        List<Customer> data = FileUtils.readObjectFromFile(pathFile);
        if (data != null) {
            this.clear();
            this.addAll(data);
        }
    }
}
