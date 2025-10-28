package hw5.flyweight;

import java.io.File;

import hw5.flyweight.CharacterStyle;

public class DocumentTest {
    @Test
    void testSaveAndLoadPreservesCharactersAndStyles() {
        Document doc = new Document();
        CharacterStyle style1 = new CharacterStyle("Arial", 12, "Red");
        doc.addCharacter('A', style1);
        File tempFile = File.createTempFile("doc", ".txt");
        doc.saveToFile(tempFile.getPath());
        Document loaded = Document.loadFromFile(tempFile.getPath());
        assertEquals('A', loaded.getCharacter(0).getSymbol());
        assertEquals(style1, loaded.getCharacter(0).getStyle());
    }

    @Test
    void testEmptyDocumentSaveLoad() {
        Document doc = new Document();
        File tempFile = File.createTempFile("emptydoc", ".txt");
        doc.saveToFile(tempFile.getPath());
        Document loaded = Document.loadFromFile(tempFile.getPath());
        assertEquals(0, loaded.characterCount());
    }

}
