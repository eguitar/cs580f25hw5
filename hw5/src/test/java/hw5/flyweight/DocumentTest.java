package hw5.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

class DocumentTest {

    @Test
    void testAddAndGetCharacter() {
        Document doc = new Document();
        CharacterStyle style = new CharacterStyle("Arial", 12, "Red");
        doc.addCharacter('A', style);
        Character c = doc.getCharacter(0);
        assertEquals('A', c.getValue());
        assertEquals(style, c.getStyle());
        assertEquals(1, doc.characterCount());
    }

    @Test
    void testSaveAndLoad() throws IOException {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        Document doc = new Document();
        CharacterStyle style = factory.getStyle("Arial", 12, "Red");
        doc.addCharacter('A', style);
        File temp = File.createTempFile("doc", ".txt");
        temp.deleteOnExit();

        doc.saveToFile(temp.getPath());
        Document loaded = Document.loadFromFile(temp.getPath(), factory);

        assertEquals(doc.characterCount(), loaded.characterCount());
        assertEquals(doc.getCharacter(0).getValue(), loaded.getCharacter(0).getValue());
        assertEquals(doc.getCharacter(0).getStyle(), loaded.getCharacter(0).getStyle());
    }
}
