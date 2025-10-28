package hw5.flyweight;

public class FlyweightDriver {

    public static void main(String[] args) {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        Document doc = new Document();

        doc.addCharacter('H', factory.getStyle("Arial", 12, "Red"));
        doc.addCharacter('e', factory.getStyle("Calibri", 14, "Blue"));
        doc.addCharacter('l', factory.getStyle("Verdana", 16, "Black"));
        doc.addCharacter('l', factory.getStyle("Arial", 12, "Red"));
        doc.addCharacter('o', factory.getStyle("Calibri", 14, "Blue"));
        doc.addCharacter('W', factory.getStyle("Verdana", 16, "Black"));
        doc.addCharacter('o', factory.getStyle("Arial", 12, "Red"));
        doc.addCharacter('r', factory.getStyle("Calibri", 14, "Blue"));
        doc.addCharacter('l', factory.getStyle("Verdana", 16, "Black"));
        doc.addCharacter('d', factory.getStyle("Arial", 12, "Red"));
        doc.addCharacter('C', factory.getStyle("Calibri", 14, "Blue"));
        doc.addCharacter('S', factory.getStyle("Verdana", 16, "Black"));
        doc.addCharacter('5', factory.getStyle("Arial", 12, "Red"));
        doc.addCharacter('8', factory.getStyle("Calibri", 14, "Blue"));
        doc.addCharacter('0', factory.getStyle("Verdana", 16, "Black"));
        doc.addCharacter('0', factory.getStyle("Arial", 12, "Red"));

        for (int i = 0; i < doc.characterCount(); i++) {
            System.out.print(doc.getCharacter(i).toString());
        }
    }
}
