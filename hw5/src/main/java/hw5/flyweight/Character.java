package hw5.flyweight;

public class Character {
    private char value;
    private CharacterStyle style;

    public Character(char value, CharacterStyle style) {
        if (style == null) throw new IllegalArgumentException("CharacterStyle cannot be null");
        this.value = value;
        this.style = style;
    }

    public char getValue() { return value; }
    public CharacterStyle getStyle() { return style; }

    @Override
    public String toString() {
        return value + "[" + style.toString() + "]";
    }
}