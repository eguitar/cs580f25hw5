package hw5.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {
    private Map<String, CharacterStyle> stylePool = new HashMap<>();

    public CharacterStyle getStyle(String font, int size, String color) {
        String key = font + "-" + size + "-" + color;
        return stylePool.computeIfAbsent(key, k -> new CharacterStyle(font, size, color));
    }

    public int getPoolSize() {
        return stylePool.size();
    }
}