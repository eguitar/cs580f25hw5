package hw5.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class SongServiceTest {

    RealSongService realService;

    @BeforeEach
    void setUp() {
        realService = new RealSongService();
        // Add sample songs to the real service
        realService.addSong(new Song("Hello", "Adele", "25", 295));
        realService.addSong(new Song("Hello", "Lionel Richie", "Can't Slow Down", 270));
        realService.addSong(new Song("Shape of You", "Ed Sheeran", "Divide", 260));
    }

    @Test
    void testSearchByIdReturnsCorrectSong() {
        Song song = realService.searchById(1);
        assertNotNull(song);
        assertEquals("Hello", song.getTitle());
    }

    @Test
    void testSearchByTitleReturnsMultiple() {
        List<Song> songs = realService.searchByTitle("Hello");
        assertEquals(2, songs.size());
    }

    @Test
    void testSearchByAlbumReturnsSongs() {
        List<Song> songs = realService.searchByAlbum("Divide");
        assertEquals(1, songs.size());
        assertEquals("Shape of You", songs.get(0).getTitle());
    }
}