package hw5.flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(char value, CharacterStyle style) {
        characters.add(new Character(value, style));
    }

    public Character getCharacter(int index) {
        return characters.get(index);
    }

    public int characterCount() {
        return characters.size();
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character ch : characters) {
                writer.write(ch.getValue() + "," + ch.getStyle().getFont() + "," +
                             ch.getStyle().getColor() + "," + ch.getStyle().getSize() + "\n");
            }
        }
    }

    public static Document loadFromFile(String filename, CharacterStyleFactory factory) throws IOException {
        Document doc = new Document();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    char value = parts[0].charAt(0);
                    String font = parts[1];
                    String color = parts[2];
                    int size = Integer.parseInt(parts[3]);
                    CharacterStyle style = factory.getStyle(font, size, color);
                    doc.addCharacter(value, style);
                }
            }
        }
        return doc;
    }
}