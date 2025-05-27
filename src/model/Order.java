/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author LE VAN MINH
 */
public class Order implements Serializable {

    private String orderCode;
    private String customerId;
    private String province;
    private String menuId;
    private int numOfTables;
    private Date eventDate;

    public Order() {
    }

    public Order(String orderCode, String customerId, String province, String menuID, int numOfTablesl, Date eventDate) {
        this.orderCode = orderCode;
        this.customerId = customerId;
        this.province = province;
        this.menuId = menuId;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMenuID() {
        return menuId;
    }

    public void setMenuID(String menuID) {
        this.menuId = menuID;
    }

    public int getNumOfTables() {
        return numOfTables;
    }

    public void setNumOfTables(int numOfTables) {
        this.numOfTables = numOfTables;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-10s | %-15s | %-6s | %-4d | %s",
                orderCode, customerId, province, menuId, numOfTables, eventDate);
    }
}
