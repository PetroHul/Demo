package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static main.Tools.inputFromConsole;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        List<Fruit> fruitsList = new ArrayList<>();
        System.out.println("Choose method input data\nFrom Console [input 1] | From file [input 2]");
        int st = 0;
        while (st < 1 || st > 2) {
            st = scanner.nextInt(); //***************add processing Exception when you input different from int***************
            if (st != 1 && st != 2)
                System.out.println("Incorrect input, please input correct data");
        }

        if (st == 1) {
            System.out.println("Input data from console");
            int i = 0;
            while (i < 2) {
                fruitsList.addAll(inputFromConsole());
                i++;
            }
            for (Object obj : fruitsList) {
                System.out.println(obj);
            }
        } else if (st == 2) {
            /* Read from file fruits*/
            String readFileFruit = "resources\\fruit.txt";
            BufferedReader br = new BufferedReader(new FileReader(readFileFruit));
            Fruit fruit = new Fruit();
            int i = 0;
            while (fruit.getFromFile(br) && i < 5) {
                fruitsList.add(fruit);
                fruit = new Fruit();
                i++;
            }
            br.close();

            /* Read with file citruses*/
            String readFileCitrus = "resources\\citruses.txt";
            BufferedReader br1 = new BufferedReader(new FileReader(readFileCitrus));
            Citrus citrus = new Citrus();
            int j = 0;
            while (citrus.getFromFile(br1) && j < 3) {
                fruitsList.add(citrus);
                citrus = new Citrus();
                j++;
            }
            br.close();
        }

        /* Print yellow fruits */
        System.out.println("=".repeat(55) + "\n" + "Fruits who have color yellow");
        List<Fruit> yellowFuitList = new ArrayList<>();
        yellowFuitList.addAll(Tools.getFruitsYellow(fruitsList));
        Tools.print(yellowFuitList);

        System.out.println("=".repeat(55)); // print line

        /* Add sorted list to file */
        Tools.sortFruitByName(fruitsList);
        Tools.print(fruitsList);
        Fruit.saveToFileFruit(fruitsList);

        /*Serelization*/
        System.out.println("XML Saved to file");
        Tools.saveFruitInXMLFile(fruitsList);

        System.out.println("XML Read from file");
        List<Fruit> serializationList = new ArrayList<>();
        serializationList.addAll(Tools.readFruitFromXMLFile());
        for (Fruit f : serializationList) {
            System.out.println(f);
        }
    }
}

