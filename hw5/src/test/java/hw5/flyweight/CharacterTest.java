package hw5.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    @Test
    public void testCharacterStoresValueAndStyle() {
        CharacterStyle style = new CharacterStyle("Arial", "Red", 12);
        Character ch = new Character('X', style);
        assertEquals('X', ch.value);
        assertEquals(style, ch.style);
    }

    @Test
    public void testCharacterToString() {
        CharacterStyle style = new CharacterStyle("Calibri", "Blue", 14);
        Character ch = new Character('A', style);
        assertEquals("A[Calibri, Blue, 14]", ch.toString());
    }
}