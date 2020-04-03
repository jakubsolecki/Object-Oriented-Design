package pl.edu.agh.dronka.shop.model;

public class Music extends Item {
    private MusicGenres genre;
    private boolean video;

    public Music(String name, Category category, int price, int quantity, MusicGenres genre, boolean video) {
        super(name, category, price, quantity);
        this.genre = genre;
        this.video = video;
    }

    public Music() { }

    public MusicGenres getGenre() {
        return genre;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }
}
