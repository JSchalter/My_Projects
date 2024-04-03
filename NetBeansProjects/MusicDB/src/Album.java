class Album {
    private final int artistID;
    private final int albumID;
    private final String name;

    public Album(int albumID, int artistID, String name) {
        this.albumID = albumID;
        this.artistID = artistID;
        this.name = name;
    }

    public int getArtistID() {
        return artistID;
    }

    public int getAlbumID() {
        return albumID;
    }

    @Override
    public String toString() {
        return name;
    }
}