package com.pluralsight.services;

import com.pluralsight.models.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public static ArrayList<Shape> loadAllShapes()
    {
        ArrayList<Shape> allShapes = new ArrayList<>();
        File data = new File("data/shapes.csv");

        // reading files
        try(
                FileReader filereader = new FileReader(data);
                Scanner reader = new Scanner(filereader)
                )

        {

            // checking shape type
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] columns = line.split("[|]");
                String type = columns[0];
                switch (type.toLowerCase()) {
                    case "circle":
                        int radius = Integer.parseInt(columns[1]);
                        Shape circle = new Circle(radius);
                        allShapes.add(circle);
                        break;
                    case "rectangle":
                        int width = Integer.parseInt(columns[1]);
                        int height = Integer.parseInt(columns[2]);
                        Shape rectangle = new Rectangle(width, height);
                        allShapes.add(rectangle);
                        break;
                    case "square":
                        int sideLength = Integer.parseInt(columns[1]);
                        Shape square = new Square(sideLength);
                        allShapes.add(square);
                        break;
                    case "triangle":
                        int base = Integer.parseInt(columns[1]);
                        int triHeight = Integer.parseInt(columns[2]);
                        Shape triangle = new Triangle(base, triHeight);
                        allShapes.add(triangle);
                        break;
                    default:
                        System.out.println();
                        System.out.println("Shape does not exist");
                        break;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("File does not exist");
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong");
        }
        return allShapes;
    }
}
