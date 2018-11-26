package main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
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
            String[] data = line.trim().split(";");
            this.setName(data[0]);
            this.setColor(data[1]);
            return true;

        }
    }

    public String toFormatFile(){
        return String.format("%s;%s", name, color);
    }

    //Exception create ablout - incorect format line if at line doesn't use toFormatFile()!

    public static void saveToFileFruit(List<Fruit> fruitsList) throws IOException{
        String fileSave = "resources\\saveFruits.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileSave));
        for (Fruit fruit:fruitsList) {
            bw.write(fruit.toFormatFile());
            bw.newLine();
        }
        bw.close();
    }

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
        return String.format("| name= %s |  color= %s | ", name, color);
    }
}
