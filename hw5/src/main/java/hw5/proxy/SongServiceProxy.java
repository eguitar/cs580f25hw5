package hw5.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {

    private RealSongService realService;
    private Map<Integer, Song> songCacheById = new HashMap<>();
    private Map<String, List<Song>> songCacheByTitle = new HashMap<>();
    private Map<String, List<Song>> songCacheByAlbum = new HashMap<>();

    public SongServiceProxy(RealSongService realService) {
        this.realService = realService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (!songCacheById.containsKey(songID)) {
            Song song = realService.searchById(songID);
            if (song != null) {
                songCacheById.put(songID, song);
            }
        }
        return songCacheById.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        String key = title.toLowerCase();
        if (!songCacheByTitle.containsKey(key)) {
            List<Song> songs = realService.searchByTitle(title);
            songCacheByTitle.put(key, songs);
        }
        return songCacheByTitle.get(key);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        String key = album.toLowerCase();
        if (!songCacheByAlbum.containsKey(key)) {
            List<Song> songs = realService.searchByAlbum(album);
            songCacheByAlbum.put(key, songs);
        }
        return songCacheByAlbum.get(key);
    }
}