package main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tools {

    static Scanner scanner = new Scanner(System.in);

    public static List<Fruit> inputFromConsole() {
        List<Fruit> fruitsList = new ArrayList<>();
        String[] arrSt;
        arrSt = scanner.nextLine().trim().split(" ");
        if (arrSt.length == 2) {
            Fruit fruit = new Fruit();
            fruit.setName(arrSt[0]);
            fruit.setColor(arrSt[1]);
            fruitsList.add(fruit);
        } else if (arrSt.length == 3) {
            Citrus citrus = new Citrus();
            citrus.setName(arrSt[0]);
            citrus.setColor(arrSt[1]);
            citrus.setVitaminC(Integer.parseInt(arrSt[2]));
            fruitsList.add(citrus);
        } else {
            System.out.println("You enter incorect format ");
        }
        return fruitsList;
    }

    //Добавити ексепшен до методу*
    public static void print(List<Fruit> fruit) {
        for (Fruit f : fruit) {
            System.out.println(f);
        }
    }

    public static List<Fruit> getFruitsYellow(List<Fruit> fruitsList) {
        List<Fruit> newFruitsList = new ArrayList<>();

        for (Fruit fruit : fruitsList) {
            if (fruit.getColor().equals("Yellow".trim().toLowerCase())) {
                newFruitsList.add(fruit);
            }
        }
        return newFruitsList;
    }

    public static List<Fruit> sortFruitByName(List<Fruit> fruits) {
        Collections.sort(fruits, new SortFruitsByName());
        return fruits;
    }

    public static void saveFruitInXMLFile(List<Fruit> fruits) throws IOException {
        FileOutputStream fos = new FileOutputStream("resources\\fruits.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(fruits);
        encoder.close();
        fos.close();
    }

    public static List<Fruit> readFruitFromXMLFile() throws IOException {
        FileInputStream fis = new FileInputStream("resources\\fruits.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        List<Fruit> decodedFtuits = (List<Fruit>) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedFtuits;
    }

}
