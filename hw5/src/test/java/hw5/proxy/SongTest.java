package hw5.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    void testSongCreationAndGetters() {
        Song song = new Song("Title", "Artist", "Album", 300);
        assertEquals("Title", song.getTitle());
        assertEquals("Artist", song.getArtist());
        assertEquals("Album", song.getAlbum());
        assertEquals(300, song.getDuration());
    }

    @Test
    void testToStringContainsMetadata() {
        Song song = new Song("Title", "Artist", "Album", 300);
        String desc = song.toString();
        assertTrue(desc.contains("Title"));
        assertTrue(desc.contains("Artist"));
        assertTrue(desc.contains("Album"));
        assertTrue(desc.contains("300"));
    }
}
