package main;
import java.io.*;
import java.util.*;

import static main.Tools.inputFromConsole;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
//        List<Fruit> fruitList = new ArrayList<Fruit>();
//        List<Citrus> citrusesList = new ArrayList<Citrus>();

        List<Fruit> fruitsList = new ArrayList<>();
        System.out.println("Choose method input data\nFrom Console [input 1] | From file [input 2]");
        int st = 0;
        while (st < 1 || st > 2) {
                st = scanner.nextInt(); //***************add processing Exception when you input different from int***************
                if(st !=1 && st !=2)
                    System.out.println("Incorrect input, please input correct data");
            }
        // what you input?
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
        Fruit.print(yellowFuitList);

        System.out.println("=".repeat(55)); // print line

        /* Add sorted list to file */
        Tools.sortFruitByName(fruitsList);
        Fruit.print(fruitsList);
        Fruit.saveToFileFruit(fruitsList);



    }
}

            /* Console read and add to fruitList + create new object fruit*/
//

//        Citrus.sortFruitByName(citrusesList);
//        Fruit.sortFruitByName(fruitList);
//        for (Fruit f: citrusesList ){
//            System.out.println(f);
//        }
//        System.out.println("Read with file");
//        /* Read with file and add to list citruses and create new instance */
//        String readFile ="resources\\citruses.txt";
//        BufferedReader br = new BufferedReader(new FileReader(readFile));
//        while (citrus.getFromFile(br)) {
//            citrusesList.add(citrus);
//            citrus = new Citrus();
//        }
//        System.out.println("Read with file");
//        /* Print at console instances wit citrusesList */
//        for (Citrus c:citrusesList) {
//            System.out.println(c);
//        }
//        System.out.println("Save into file");
//        /* Save our object citruses into file saveCitruses.txt*/
//        Fruit.saveFruitInXMLFile(fruitList);
//        String writeFile ="resources\\saveFruits.txt";
//        BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));
//        for (Fruit f:fruitList) {
//            f.saveToFile(bw);
//        }
//        bw.close();
//
//        System.out.println("XML Save");
//        Fruit.saveFruitInXMLFile(fruitList);
//
//        List<Fruit> fructXML = Fruit.readFruitFromXMLFile();
//        for (Fruit fe: fructXML) {
//            System.out.println(fe);
//        }
//
//        System.out.println("XML Read");
//        System.out.println(Fruit.readFruitFromXMLFile());
//
//        //dell
////        XMLDecoder decoder = new XMLDecoder(new FileInputStream("fruits.xml"));
////        System.out.println(fruit.getFromFile(br));
////        System.out.println(fruit);
//
//       // fruit.print(fruit.getFruitsFromFile(br));
//
//        //cheack github

