import java.sql.*;
import java.util.*;

public class MusicDB {
    private final String dbUrl;

    public MusicDB(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public List<Artist> populateArtistsAndAlbums() {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM Artists ORDER BY Name";
        try (Connection connection = DriverManager.getConnection(dbUrl);
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int artistID = rs.getInt("ArtistID");
                String name = rs.getString("Name");
                Artist artist = new Artist(artistID, name);
                artists.add(artist);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        artists.forEach(artist -> artist.setAlbums(getAlbumsForArtist(artist.getArtistID())));
        return artists;
    }

    private List<Album> getAlbumsForArtist(int artistID) {
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM Albums WHERE ArtistID = ? ORDER BY Name";
        try (Connection connection = DriverManager.getConnection(dbUrl);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, artistID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int albumID = rs.getInt("AlbumID");
                    String name = rs.getString("Name");
                    Album album = new Album(albumID, artistID, name);
                    albums.add(album);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return albums;
    }
}





