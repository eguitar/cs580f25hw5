package hw5.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongServiceProxyTest {

    private RealSongService realService;
    private SongServiceProxy proxy;

    @BeforeEach
    void setUp() {
        realService = new RealSongService();
        realService.addSong(new Song("Hello", "Adele", "25", 295));
        realService.addSong(new Song("Hello", "Lionel Richie", "Can't Slow Down", 270));
        proxy = new SongServiceProxy(realService);
    }

    @Test
    void testSearchByIdCaching() {
        long start = System.currentTimeMillis();
        Song firstCall = proxy.searchById(1);
        long firstDuration = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        Song secondCall = proxy.searchById(1);
        long secondDuration = System.currentTimeMillis() - start;

        assertEquals(firstCall, secondCall);
        assertTrue(secondDuration < firstDuration); // Cached call faster
    }

    @Test
    void testSearchByTitleCaching() {
        List<Song> firstCall = proxy.searchByTitle("Hello");
        List<Song> secondCall = proxy.searchByTitle("Hello");
        assertEquals(firstCall, secondCall);
    }

    @Test
    void testSearchByAlbumCaching() {
        List<Song> firstCall = proxy.searchByAlbum("25");
        List<Song> secondCall = proxy.searchByAlbum("25");
        assertEquals(firstCall, secondCall);
    }
}