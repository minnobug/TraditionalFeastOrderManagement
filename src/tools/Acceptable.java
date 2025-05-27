/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

/**
 *
 * @author LE VAN MINH
 */
public class Acceptable {

    public static final String CUS_ID_VALID = "^[CGKcgk]\\d{4}$";
    public static final String NAME_VALID = "^[\\p{L} ]{2,25}$";
    public static final String PHONE_VALID = "^0\\d{9}$";
    public static final String EMAIL_VALID = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";

    static boolean isValid(String data, String pattern) {
        return data != null && data.matches(pattern);
    }
}
