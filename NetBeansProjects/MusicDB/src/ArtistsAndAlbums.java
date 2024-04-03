import java.util.*;

public class ArtistsAndAlbums {
    public static void main(String[] args) {
        String dbUrl = "/Users/swapfile/IdeaProjects/MusicDB/src/music_artists.sqlite";
        MusicDB db = new MusicDB(dbUrl);
        List<Artist> artists = db.populateArtistsAndAlbums();

        System.out.println("Artists and Album Listings\n");

        System.out.println("Artists\n-------");
        artists.forEach(artist -> System.out.println(artist.getName()));

        System.out.println("\nAlbums By Artist\n----------------");
        artists.forEach(artist -> System.out.print(artist.toString()));
        System.out.print("\n");
    }
}
