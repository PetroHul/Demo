package main;

import java.util.Comparator;

public class SortFruitsByName implements Comparator<Fruit> {
    @Override
    public int compare(Fruit f1, Fruit f2){
        return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
    }
}


