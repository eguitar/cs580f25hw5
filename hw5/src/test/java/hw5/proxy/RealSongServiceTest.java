package hw5.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class RealSongServiceTest {

    private RealSongService realService;

    @BeforeEach
    void setup() {
        realService = new RealSongService();
        realService.addSong(new Song("Song1", "Artist1", "Album1", 180));
        realService.addSong(new Song("Song2", "Artist2", "Album2", 210));
    }

    @Test
    void testSearchByIdReturnsExpectedSong() {
        Song song = realService.searchById(1);
        assertNotNull(song);
        assertEquals("Song1", song.getTitle());
    }

    @Test
    void testSearchByTitleReturnsList() {
        List<Song> songs = realService.searchByTitle("Song1");
        assertEquals(1, songs.size());
    }

    @Test
    void testSearchByAlbumReturnsList() {
        List<Song> songs = realService.searchByAlbum("Album2");
        assertEquals(1, songs.size());
        assertEquals("Song2", songs.get(0).getTitle());
    }
}