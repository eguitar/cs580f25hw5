package hw5.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProxyDriverTest {

    @Test
    void testProxyDriverSearches() {
        RealSongService realService = new RealSongService();
        realService.addSong(new Song("Yesterday", "The Beatles", "Help!", 150));
        realService.addSong(new Song("Hey Jude", "The Beatles", "Bootleg", 190));

        SongServiceProxy proxy = new SongServiceProxy(realService);

        Song s1 = proxy.searchById(1);
        assertNotNull(s1);
        assertEquals("Yesterday", s1.getTitle());

        List<Song> songs = proxy.searchByAlbum("Bootleg");
        assertEquals(1, songs.size());
        assertEquals("Hey Jude", songs.get(0).getTitle());
    }
}