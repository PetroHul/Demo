package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws Exception{
        //   fruit.input();
//        public void input(int a){
     //   BufferedReader in = new BufferedReader(Reader in, int size);

        List<Fruit> fruits = new ArrayList<Fruit>();
        File readFile = new File ("resources\\file.txt");
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        Citrus fruit = new Citrus();

        //System.out.println(fruit.getFromFile(br));

        while (fruit.getFromFile(br)) {
            fruits.add(fruit);
            fruit = new Citrus();

        }
        for (Fruit f:fruits) {
            System.out.println(f);
        }
//        System.out.println(fruit.getFromFile(br));
//        System.out.println(fruit);

        //fruit.print(fruit.getFruitsFromFile(br));
    }
//        List<Fruit> fruits = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Input Fruit name and color");
//            Fruit.input(fruits);
//        }
//        Fruit.print(fruits);
//        for (Fruit f:fruits) {
//            if(fruits.get(1).getColor() == "Yellow") {
//                String str = fruits.get(0).getName();
//                System.out.println(str);
//            }
//        }
       // Citrus.gramToMilligramVC(5);// gram v milligram

//        List<Fruit> fruits = new ArrayList<>();
//        fruits.add(new Fruit("Banan","Yellow"));
//        fruits.add(new Fruit("Apple","Green"));
//        fruits.add(new Fruit("Lime","Green"));
//        fruits.add(new Fruit("Kiwifruit","Green"));
//        fruits.add(new Fruit("Lemon","Yellow"));

// }

//        Fruit fruit1 = new Fruit();
//
//        List<Fruit> fruits = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Fruit fruit = new Fruit();
//            fruit.input();
//            fruits.add(fruit);
//        }
}
