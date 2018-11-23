package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fruit {
    private String name;
    private String color;
    private Fruit fruit;

    public Fruit() {
    }

    public Fruit(String  name, String color){
        this.name = name;
        this.color = color;
    }


    public static List<Fruit> getConsoleObject(List<Fruit> fruit){
        Scanner scanner = new Scanner(System.in);
        String name =  scanner.nextLine();
        String color =  scanner.nextLine();
        fruit.add(new Fruit(name,color));
        return fruit;
    }

    //print file
    //Добавити ексепшен до методу*
    public  void print(List<Fruit> fruit){
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
            String[] date = line.split(",");
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
            String[] data = line.split(",");
            this.setName(data[0]);
            this.setColor(data[1]);
            return true;

        }
    }

    public static List<Fruit> saveFruitFromFile(File file ) throws IOException{
        File saveFile = new File ("resources\\nextFileSave.txt");
        List<Fruit> fruits = new ArrayList<Fruit>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> fileList = new ArrayList();
        String line;
        while ((line = br.readLine()) != null){
            Fruit fruit = new Fruit();
            String[] date = line.split(",");
            if(date.length == 2) {
                fruit.name = date[0];
                fruit.color = date[1];
                fruits.add(fruit);
            }
        }
        br.close();
        return fruits;
    }

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
        return "[ name= " + name + " color= " + color + "|";
    }
}
