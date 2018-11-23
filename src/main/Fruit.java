package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Fruit {
    private String name;
    private String color;

    public Fruit() {
    }

    public Fruit(String  name, String color){
        this.name = name;
        this.color = color;
    }


    public void readWithConsole(Scanner scanner){
        String name = scanner.nextLine().toLowerCase().trim();
        String color = scanner.nextLine().toLowerCase().trim();
        this.setName(name);
        this.setColor(color);
    }

    //print file
    //Добавити ексепшен до методу*
    public void print(List<Fruit> fruit){
        for (Fruit f: fruit) {
            System.out.println(f.toString());
        }
    }
    public static List<Fruit> getFruitsFromFile( BufferedReader br) throws IOException{
        List<Fruit> fruits = new ArrayList<Fruit>();
        List<String> fileList = new ArrayList();
        String line;
        while ((line = br.readLine()) != null){
            Fruit fruit = new Fruit();
            String[] date = line.split(";");
            if(date.length == 2) {
                fruit.name = date[0];
                fruit.color = date[1];
                fruits.add(fruit);
            }
        }
        return fruits;
    }


    public boolean getFromFile( BufferedReader br) throws IOException{
        String line;
        if ((line = br.readLine()) == null){
            return false;
        }
        else {
            String[] data = line.split(";");
            this.setName(data[0]);
            this.setColor(data[1]);
            return true;

        }
    }

    public void saveToFile( BufferedWriter bw) throws IOException{
        String line = this.name + ";" + this.color + "\n";
        bw.write(line);
    }

    public static void sortFruitByName(List fruits) {
        System.out.println("Sorted fruit list");
        Collections.sort(fruits, new SortFruitsByName());
    }


//    public static List<Fruit> saveFruitFromFile(File file ) throws IOException{
//        File saveFile = new File ("resources\\saveCitruses.txt");
//        List<Fruit> fruits = new ArrayList<Fruit>();
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        List<String> fileList = new ArrayList();
//        String line;
//        while ((line = br.readLine()) != null){
//            Fruit fruit = new Fruit();
//            String[] date = line.split(",");
//            if(date.length == 2) {
//                fruit.name = date[0];
//                fruit.color = date[1];
//                fruits.add(fruit);
//            }
//        }
//        br.close();
//        return fruits;
//    }

    //print file
//    public static void print(List<String> fileList){
//        for (String i: fileList) {
//            System.out.println(i);
//        }
//    }
    //print console


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "[ name= " + name + " | " + " color= " + color + " | ";
    }
}
