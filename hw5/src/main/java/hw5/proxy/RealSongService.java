package hw5.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RealSongService implements SongService {

    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {}
        return songs.stream().skip(songID - 1).findFirst().orElse(null);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {}
        return songs.stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {}
        return songs.stream()
                .filter(s -> s.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }
}