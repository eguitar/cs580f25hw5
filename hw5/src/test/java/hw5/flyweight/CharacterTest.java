package hw5.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void testCharacterStoresValueAndStyle() {
        CharacterStyle style = new CharacterStyle("Arial", 12, "Red");
        Character ch = new Character('X', style);
        assertEquals('X', ch.getValue());
        assertEquals(style, ch.getStyle());
    }

    @Test
    void testCharacterNullStyleThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Character('A', null);
        });
    }

    @Test
    void testToStringMatchesExpected() {
        CharacterStyle style = new CharacterStyle("Calibri", 14, "Blue");
        Character ch = new Character('A', style);
        assertEquals("A[Calibri, Blue, 14]", ch.toString());
    }
}
