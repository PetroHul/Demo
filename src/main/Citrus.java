package main;

import java.io.BufferedReader;
import java.io.IOException;

public class Citrus extends Fruit {
    private int vitaminC;

    public Citrus(String name, String color, int vitaminC) {
        super(name, color);
        this.vitaminC = vitaminC;
    }

    @Override
    public boolean getFromFile(BufferedReader br) throws IOException {
        String line;
        //super.getFromFile(br);
        if ((line = br.readLine()) == null) {
            return false;
        } else {
            String[] data = line.split(";");
            // Citrus citrus = new Citrus();
            this.setName(data[0]);
            this.setColor(data[1]);
            this.vitaminC = Integer.parseInt(data[2]);
            return true;
        }
    }

    public int getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(int vitaminC) {
        this.vitaminC = vitaminC;
    }

    public Citrus() {
    }

    @Override
    public String toString() {
        return String.format("%svitaminC= %s milligramms |", super.toString(), this.vitaminC);
    }

    @Override
    public String toFormatFile() {
        return String.format("%s;%s", super.toFormatFile(), vitaminC);
    }
}
