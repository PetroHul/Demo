package main;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Fruit> fruitList = new ArrayList<Fruit>();
        List<Citrus> citrusesList = new ArrayList<Citrus>();
        Citrus citrus = new Citrus();
        Fruit fruit = new Fruit();


        /* Console read and add to fruitList + create new object fruit*/
        Scanner scanner = new Scanner(System.in);
        int i=0;
        while (i<2) {
            fruit.readWithConsole(scanner);
            fruitList.add(fruit);
            fruit = new Fruit();
            i++;
        }
        Citrus.sortFruitByName(citrusesList);
        Fruit.sortFruitByName(fruitList);
        for (Fruit f: citrusesList ){
            System.out.println(f);
        }
        /* Read with file and add to list citruses and create new instance */
        String readFile ="resources\\citruses.txt";
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        while (citrus.getFromFile(br)) {
            citrusesList.add(citrus);
            citrus = new Citrus();

        }
        /* Print at console instances wit citrusesList */
        for (Citrus c:citrusesList) {
            System.out.println(c);
        }
        /* Save our object citruses into file saveCitruses.txt*/
        String writeFile ="resources\\saveFruits.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));
        for (Fruit f:fruitList) {
            f.saveToFile(bw);
        }
        bw.close();

        Fruit.saveFruitInXMLFile(fruitList);
        List<Fruit> fructXML = Fruit.readFruitFromXMLFile();
        for (Fruit fe: fructXML) {
            System.out.println(fe);
        }
       // System.out.println(Fruit.readFruitFromXMLFile());
      //  XMLDecoder decoder = new XMLDecoder(new FileInputStream("fruits.xml"));
//        System.out.println(fruit.getFromFile(br));
//        System.out.println(fruit);

        //fruit.print(fruit.getFruitsFromFile(br));

        //cheack github
    }
}
