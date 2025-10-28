package hw5.proxy;

import java.util.List;

public class ProxyDriver {

    public static void main(String[] args) {
        RealSongService realService = new RealSongService();

        realService.addSong(new Song("Yesterday", "The Beatles", "Help!", 123));
        realService.addSong(new Song("Let it Be", "The Beatles", "Let it Be", 180));
        realService.addSong(new Song("Imagine", "John Lennon", "Imagine", 190));
        realService.addSong(new Song("Hey Jude", "The Beatles", "Bootleg", 210));
        realService.addSong(new Song("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354));

        SongService proxy = new SongServiceProxy(realService);

        List<Song> beatlesSongs = proxy.searchByAlbum("Help!");
        System.out.println("Songs in album 'Help!': " + beatlesSongs);

        Song song = proxy.searchById(3);
        System.out.println("Song with ID 3: " + song);

        List<Song> imagineSongs = proxy.searchByTitle("Imagine");
        System.out.println("Songs titled 'Imagine': " + imagineSongs);

        proxy.searchById(3);
        proxy.searchByTitle("Imagine");
        proxy.searchByAlbum("Help!");
    }
}