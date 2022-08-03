package model;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class OrderModel {

    /* An instance of a File */
    private File file;

    public OrderModel() {
    }

    /**
     * Method to create a file in the specified path
     * 
     * @param path
     */
    public File createFile(String path) {
        try {
            return file = new File(path);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Method to write into the file
     * 
     * @param content
     *
     */
    public boolean writeFile(String content, File file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to read the file
     * 
     * @param file
     * @return
     */
    public String [] readFile(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("/");
                return tokens;
            }
            scanner.close();
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
