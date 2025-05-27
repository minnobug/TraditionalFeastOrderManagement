/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.io.*;
import java.util.List;

/**
 *
 * @author LE VAN MINH
 */
public class FileUtils {
    public static void saveObjectToFile(List<?> list, String pathFile) {
        try {
            FileOutputStream fos = new FileOutputStream(pathFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Failed to save to file: " + e.getMessage());
        }
    }
    
    public static <T> List<T> readObjectFromFile(String pathFile) {
     File file = new File(pathFile);
        if (!file.exists()) return null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<T> list = (List<T>) ois.readObject();
            ois.close();
            fis.close();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to read from file: " + e.getMessage());
            return null;
        }
    }
}
