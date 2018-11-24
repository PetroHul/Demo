package main;

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
            Citrus citrus= new Citrus();
            citrus.setName(arrSt[0]);
            citrus.setColor(arrSt[1]);
            citrus.setVitaminC(Integer.parseInt(arrSt[2]));
            fruitsList.add(citrus);
        } else {
            System.out.println("You enter incorect format ");
        }
        return fruitsList;
    }

    public static List sortFruitByName(List fruits) {
        System.out.println("Sorted fruit list");
        Collections.sort(fruits, new SortFruitsByName());
        return fruits;
    }


}
