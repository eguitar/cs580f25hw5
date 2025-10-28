package hw5.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightDriverTest {

    @Test
    void testFlyweightDriverCreatesDocumentWithExpectedStyles() {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        Document doc = new Document();

        doc.addCharacter('H', factory.getStyle("Arial", 12, "Red"));
        doc.addCharacter('e', factory.getStyle("Calibri", 14, "Blue"));
        doc.addCharacter('l', factory.getStyle("Verdana", 16, "Black"));

        assertEquals(3, doc.characterCount());
        assertEquals(3, factory.getPoolSize());
    }
}
