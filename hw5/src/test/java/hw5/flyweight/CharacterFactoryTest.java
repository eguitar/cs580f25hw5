package hw5.flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterFactoryTest {

    @Test
    void testSameStyleIsShared() {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        CharacterStyle style1 = factory.getStyle("Arial", 12, "Red");
        CharacterStyle style2 = factory.getStyle("Arial", 12, "Red");
        assertSame(style1, style2);
    }

    @Test
    void testDifferentStylesAreNotShared() {
        CharacterStyleFactory factory = new CharacterStyleFactory();
        CharacterStyle style1 = factory.getStyle("Arial", 12, "Red");
        CharacterStyle style2 = factory.getStyle("Verdana", 16, "Black");
        assertNotSame(style1, style2);
    
}
