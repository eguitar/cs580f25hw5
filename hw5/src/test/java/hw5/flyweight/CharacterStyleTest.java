package hw5.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterStyleTest {
    @Test
    void testStyleGetters() {
        CharacterStyle style = new CharacterStyle("Arial", 12, "Red");
        assertEquals("Arial", style.getFont());
        assertEquals(12, style.getSize());
        assertEquals("Red", style.getColor());
    }

    @Test
    void testStyleEquality() {
        CharacterStyle s1 = new CharacterStyle("Arial", 12, "Red");
        CharacterStyle s2 = new CharacterStyle("Arial", 12, "Red");
        assertEquals(s1, s2);
    }

}
