package ua.lviv.iot.houses.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import ua.lviv.iot.houses.model.House;

public class HouseWriter {
    
    public static void writeToFile(List<House> listOfHouses) {
        try (PrintWriter writer = new PrintWriter(
                new File("C:\\Users\\Farmose\\Desktop\\github\\Java_lab3\\Lab3\\houses.csv"))) {
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < listOfHouses.size(); i++) {
                House element = listOfHouses.get(i);
                sb.append(element.getHeaders());
                sb.append("\n");
                sb.append(element.toCSV());
                sb.append("\n-------------------------------------------------------------------------\n");
            }
            
            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
