import java.util.ArrayList;
import java.util.List;

class Artist {
    private final int artistID;
    private final String name;
    private List<Album> albums;

    public Artist(int artistID, String name) {
        this.artistID = artistID;
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public int getArtistID() {
        return artistID;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(name).append("\n");
        for (Album album : albums) {
            output.append("\t").append(album).append("\n");
        }
        return output.toString();
    }
}
